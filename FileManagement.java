

import java.io.File;

import java.util.ArrayList;

public class FileManagement{

	private static ArrayList<FileObject> fileObjects;
	public static void main(String [] args){
		if(args.length > 0){

			if(args[0].equals("test-path")){
				// This is where I will test the path
				System.out.println("Working Directory = " +
								System.getProperty("user.dir"));
			}

		}else{
			startProcess();
		}
	}

	public static void startProcess(){
		String path = System.getProperty("user.dir");
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();


		fileObjects = new ArrayList<FileObject>();



		System.out.println("Loading a list of files...");
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if(listOfFiles[i].getName().equals("FileManagement.java") || listOfFiles[i].getName().equals("FileManagement.class")  || listOfFiles[i].getName().equals("FileObject.java") || listOfFiles[i].getName().equals("FileObject.class") || listOfFiles[i].getName().equals(".gitignore") ){
						continue;
				}else{
						fileObjects.add(new FileObject(listOfFiles[i].getName()));
				}

			}
		}

		System.out.println("List Of Files loaded successfully!!!");

		System.out.println("Now renaming a list of files...");
		System.out.println("");

		for(FileObject fileObject : fileObjects){
			// File (or directory) with old name
			File file = new File(path+"/"+fileObject.getOriginalFileName());

			// File (or directory) with new name
			File file2 = new File(path+"/"+fileObject.getNewFileName());

			// Rename file (or directory)
			boolean success = file.renameTo(file2);

			if (!success) {
				// File was not successfully renamed
				System.out.println(fileObject.getOriginalFileName()+" was not renamed");
			}else{
				System.out.println("successfully renamed the file to: "+fileObject.getNewFileName());
			}
	}





	}





}
