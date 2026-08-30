package filepacker;

import java.io.*;
import java.util.*;

class Unpacker
{
    public static void main(String A[]) throws Exception
    {
        int iRet = 0;
        int FileSize = 0;

        Scanner sobj = new Scanner(System.in);

        String PackFileName = null;
        String ExtractFolder = null;
        String Header = null;
        String FileName = null;

        byte HeaderBuffer[] = new byte[100];
        byte Buffer[] = new byte[1024];

        System.out.println("Enter packed file name : ");
        PackFileName = sobj.nextLine();

        System.out.println("Enter extract folder name : ");
        ExtractFolder = sobj.nextLine();

        File fobjpack = new File(PackFileName);

        if(!fobjpack.exists())
        {
            System.out.println("Packed file does not exist");
            sobj.close();
            return;
        }

        File fobjfolder = new File(ExtractFolder);

        if(!fobjfolder.exists())
        {
            fobjfolder.mkdir();
        }

        FileInputStream fiobj = new FileInputStream(fobjpack);

        while(true)
        {
            // Read 100 byte header
            iRet = fiobj.read(HeaderBuffer);

            if(iRet == -1)
            {
                break;
            }

            if(iRet != 100)
            {
                System.out.println("Invalid packed file");
                break;
            }

            Header = new String(HeaderBuffer);

            // Remove extra spaces
            Header = Header.trim();

            // Separate file name and file size
            String Parts[] = Header.split(" ");

            FileName = Parts[0];
            FileSize = Integer.parseInt(Parts[1]);

            System.out.println("Extracting : " + FileName);
            System.out.println("File Size  : " + FileSize);

            File fobj = new File(fobjfolder, FileName);

            FileOutputStream foobj = new FileOutputStream(fobj);

            int Remaining = FileSize;

            while(Remaining > 0)
            {
                int ReadSize = Math.min(Buffer.length, Remaining);

                iRet = fiobj.read(Buffer, 0, ReadSize);

                if(iRet == -1)
                {
                    break;
                }

                foobj.write(Buffer, 0, iRet);

                Remaining = Remaining - iRet;
            }

            foobj.close();

            if(Remaining != 0)
            {
                System.out.println("Error while extracting " + FileName);
                break;
            }
        }

        fiobj.close();

        System.out.println("Unpacking completed successfully.");

        sobj.close();
    }
}