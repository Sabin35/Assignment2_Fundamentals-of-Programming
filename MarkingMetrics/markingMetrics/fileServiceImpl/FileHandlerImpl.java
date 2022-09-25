package markingMetrics.fileServiceImpl;

import markingMetrics.entity.Grades;
import markingMetrics.fileService.FileHandler;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public
class FileHandlerImpl implements FileHandler {

    private FileReader file;

    private BufferedReader buffer;

    public
    FileHandlerImpl ( ) throws FileNotFoundException{
    try{
        file = new FileReader ( System.getProperty ( "user.dir" ) + "/resources/students-grade.csv" );

        buffer = new BufferedReader ( file );
    }
    catch(FileNotFoundException e){
        System.out.println("File doesnot exist in the directory. Please check your folder");
        System.out.println("Terminating the program");
    }
    
}
    @Override
    public
    List < Grades > readMarksFromFile ( ) {

        return buffer
                .lines ( )
                .skip ( 2 )
                .map ( s -> {
                    String[] marksDetail = s.split ( "," );

                    Grades grades = new Grades ( );

                    try {

                        grades.setLastName ( marksDetail[0] );
                        grades.setFirstName ( marksDetail[1] );
                        grades.setStudent_id ( marksDetail[2] );
                        grades.setA1 ( Double.parseDouble ( marksDetail[3] ) );
                        grades.setA2 ( Double.parseDouble ( marksDetail[4] ) );
                        grades.setA3 ( Double.parseDouble ( marksDetail[5] ) );

                    } catch (ArrayIndexOutOfBoundsException e) {

                        throw new IllegalArgumentException ( "Invalid input provided in the file data. all six fields must be present. please check the data in the file." );

                    } catch (NumberFormatException e) {

                        throw new IllegalArgumentException ( "Invalid datatype provided please input the correct datatype in correct fields." );

                    }

                    return grades;
                } ).collect ( Collectors.toList ( ) );

    }

    @Override
    public
    String readUnitFromFile ( ) throws IOException {

        String line = buffer.readLine ( );

        String[] stringArray = line.split ( ":" );

        return stringArray[1].trim ( );

    }
}
