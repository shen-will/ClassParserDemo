
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static  java.lang.System.out;

public class Main {

    public static String defClassPath = "C:/Users/Hasee/IdeaProjects/ClassPaserDemo/out/production/ClassPaserDemo/ClassFileReader.class";

    public static  String classPath = defClassPath;

    private static boolean checkPathArg(String[] args){

        if(args.length > 1)
            classPath = args[1];

        return classPath != null;

    }


    public static void main(String[] args) {

        if(!checkPathArg(args)){
            out.println("class path not found!");
            return;
        }

        ClassFileReader reader =new ClassFileReader(classPath);

        ClassFileHeader header = reader.readClassHeader();

        out.println(Disassembler.disassembleClass(reader.clFile));

        out.println("class file parse finish....");
    }





}
