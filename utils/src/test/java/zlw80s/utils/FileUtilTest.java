package zlw80s.utils;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileUtilTest extends TestCase {
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public FileUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( FileUtilTest.class );
	}

	/**
	 * 
	 */    
	public void testFileApplicationInfo(){
		
		String path = "D:\\test\\123.txt";
		FileUtil.fileApplicationInfo(path);
	}
	
	public void testDeleteFile(){
		
		String path = "D:\\test\\123.txt";
		File file = new File(path);
		FileUtil.deleteFile(file);
		
	}
	
	public void testDeleteDirectory(){
		
		String path = "D:\\test\\test1";
		File file = new File(path);
		FileUtil.deleteFile(file);
	}
	
	public void testFileList(){
		
		String path = "D:\\test";
		File file = new File(path);
		FileUtil.fileList(file);
		
	}
	
	/**
	 * 
	 */
	public void testGetDirSize(){
		
		String path = "D:\\test";
		File file = new File(path);
		System.out.println(path+":"+FileUtil.getDirSize(file)); 	
	}
	
	public void testFileInputStreamRead() throws Exception{
		String path = "D:\\test\\2.png";
		FileUtil.fileInputStreamRead(path);
	}
	
	public void testFileRead() throws Exception{
		String path = "D:\\test\\123.txt";
		FileUtil.fileRead(path);
	}
	
	
	public void testFileOutStreamWriter() throws Exception{
		String path = "D:\\test\\3.png";
		char[] inputs = new char[]{'A','B'};
		FileUtil.fileOutStreamRead(path,inputs);
	}
	
	public void testFileWriter() throws Exception{
		String path = "D:\\test\\223.txt";
		String[] inputs = new String[]{"yes","we","can"};
		FileUtil.fileWriter(path,inputs);
	}
	
	public void testFileAppendWriter() throws Exception{
		String path = "D:\\test\\223.txt";
		String[] inputs = new String[]{"who,","where,","what"};
		FileUtil.fileAppendWriter(path,inputs);
	}
	
	public void testCopyFile(){
		String oldPath = "D:\\test\\223.txt";
		String newPath = "D:\\test\\323.txt";
		FileUtil.copyFile(oldPath, newPath);
	}

	public void testCopyFolder(){
		
		String oldPath = "D:\\test";
		String newPath = "D:\\test2";
		FileUtil.copyFolder(oldPath, newPath);
	}
	
	public void testCutFile() throws IOException{
		
		String oldFilePath = "D:\\test\\123.txt";
		String destFolder = null;
		int size = 1;
		FileUtil.cutFile(oldFilePath, destFolder,size);
		
	}
	
	public void testUniteFile() throws IOException{
		
		String fileName = "D:\\test\\new123.txt";
		String filterFolder = "D:\\test\\123-cut";
		String filterName = "temp";
		FileUtil.unite(fileName, filterFolder, filterName);
	}
	
	
	public void testNewFileReader(){
		
		String fileName = "D:\\test\\new123.txt";
		File file = new File(fileName);
		if(file.exists()){
			System.out.println(FileUtil.newfileReader(file));
		}else{
			System.out.println("文件不存在");
		}
		
	}
	
	public void testNewFileWriter(){
		
		String fileName = "D:\\test\\new123.txt";
		File file = new File(fileName);
		if(file.exists()){
			FileUtil.newfileWriter(file,"222");
		}else{
			System.out.println("文件不存在");
		}
	}

	public void testNewCopy() throws IOException{
		String srcFile = "D:\\test\\new123.txt";
		String destFile = "D:\\test\\new123123.txt";
		FileUtil.newCopy(srcFile, destFile);
		
	}
	
}	
