package zlw80s.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Date;

public class FileUtil {

	/**
	 * 文件属性信息
	 * @param path
	 */
	public static void fileApplicationInfo(String path){

		File file = new File(path);
		System.out.println("*****文件属性信息 *****");
		System.out.println("文件是否存在："+file.exists());
		if(!file.exists()){
			System.out.println("文件不存在");
		}else{
			System.out.println("文件名:"+file.getName());
			System.out.println("上级目录:"+file.getParent());
			System.out.println("是否可读:"+file.canRead());
			System.out.println("是否可写:"+file.canWrite());
			System.out.println("绝对路径:"+file.getAbsolutePath());
			System.out.println("相对路径:"+file.getPath());
			System.out.println("是否为绝对路径:"+file.isAbsolute());
			System.out.println("是否为目录:"+file.isDirectory());
			System.out.println("是否为文件:"+file.isFile());
			System.out.println("是否为隐藏文件:"+file.isHidden());
			System.out.println("最后修改时间:"+new Date(file.lastModified()));
			System.out.println("文件长度:"+file.length());

			if(0==file.length()){
				System.out.println("文件为空！");
			}

		}

	}

	/**
	 * 删除文件
	 * @param file
	 */
	public static void deleteFile(File file){

		if(file.exists()){
			if(file.isFile()){

			}else if(file.isDirectory()){
				File[] files = file.listFiles();
				for(int i=0;i<files.length;i++){
					deleteFile(files[i]);
				}
			}

			file.delete();
		}else{
			System.out.println("所要删除的文件不存在");
		}
	} 

	/**
	 * 遍历文件
	 * @param file
	 */
	public static void fileList(File file){

		if(file.isFile()){
			System.out.println("文件-->"+file.getName());
		}else if(file.isDirectory()){
			System.out.println("文件目录-->"+file.getName());
			File[] files = file.listFiles();
			for(int i=0;i<files.length;i++){
				fileList(files[i]);
			}
		}
	}

	/**
	 * 获取文件夹大小
	 * @param file
	 * @return
	 */
	public static long getDirSize(File file){

		long size = 0;
		size = getDirItemSize(file,size);
		return size;
	}

	/**
	 * 获取文件大小
	 * @param file
	 */
	public static long getDirItemSize(File file,long size){

		if(file.isFile()){
			size += file.length();
		}else if(file.isDirectory()){

			File[] files = file.listFiles();
			for(int i=0;i<files.length;i++){
				size += getDirItemSize(files[i],size);
			}
		}

		return size;
	}

	public static void fileInputStreamRead(String path) throws IOException{

		int temp = -1;
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		while((temp=bis.read())!=-1){
			System.out.println((char)temp);
		}

		bis.close();
		fis.close();

	}

	public static void fileRead(String path) throws IOException{

		String temp = null;
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		while((temp=br.readLine())!=null){
			System.out.println(temp);
		}

		br.close();
		fr.close();

	}

	public static void fileOutStreamRead(String path,char[] inputs) throws IOException{

		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		for(char input:inputs){
			bos.write(input);
		}

		bos.close();
		fos.close();
	}

	public static void fileWriter(String path,String[] inputs) throws IOException{

		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		for(String input:inputs){
			pw.println(input);
		}

		pw.close();
		bw.close();
		fw.close();
	}

	public static void fileAppendWriter(String name,String[] inputs) throws IOException{

		FileWriter fw = new FileWriter(name,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		for(String input:inputs){
			pw.print(input);
		}

		pw.close();
		bw.close();
		fw.close();

	}


	public static void copyFile(String oldPath,String newPath){

		int byteRead = 0;

		try{
			File oldFile = new File(oldPath);
			if(oldFile.exists()){
				InputStream inputStream = new FileInputStream(oldPath);
				FileOutputStream fos = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024];
				while((byteRead=inputStream.read(buffer))!= -1){
					fos.write(buffer, 0, byteRead);
				}
				inputStream.close();
			}
		}catch(Exception e){
			System.out.println("复制单个文件出错");
			e.printStackTrace();
		}
	}


	public static void copyFolder(String oldPath,String newPath){
		try{
			(new File(newPath)).mkdirs();
			File oldFile = new File(oldPath);
			String[] files = oldFile.list();
			File temp = null;
			for(int i=0;i<files.length;i++){
				if(oldPath.endsWith(File.separator)){
					temp = new File(oldPath + files[i]);
				}else{
					temp = new File(oldPath + File.separator + files[i]);
				}

				if(temp.isFile()){
					FileInputStream fis = new FileInputStream(temp);
					FileOutputStream fo = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] buffer = new byte[1024*5];
					int len = 0;
					while((len= fis.read(buffer))!= -1){
						fo.write(buffer, 0, len);
					}
					fo.flush();
					fo.close();
					fis.close();
				}

				if(temp.isDirectory()){
					copyFolder(oldPath + "/" + files[i],newPath + "/"+ files[i]);
				}
			}
		}catch(Exception e){
			System.out.println("复制文件夹出错");
			e.printStackTrace();
		}
	}


	public static void cutFile(String path,String destFolder,final int size) throws IOException{

		int fsize = size * 1024;
		File oldFile = new File(path);
		if(!oldFile.exists()){
			throw new FileNotFoundException();
		}

		String fdestFolderName = null;

		//目标文件夹为空时，本地创建一个文件夹，用于存放分割后的文件
		if(null == destFolder){
			String folderName = oldFile.getParent()+ "\\" + oldFile.getName().substring(0,oldFile.getName().indexOf('.'))+"-cut";
			File newFolder = new File(folderName);
			System.out.println(folderName);
			newFolder.mkdir();
			fdestFolderName = folderName;
		}else{
			fdestFolderName = destFolder;
		}

		int number = 0;
		int fileLength = (int)oldFile.length();
		number = fileLength / fsize;
		System.out.println(fileLength);

		oldFile.length();
		//读取文件并进行分割
		RandomAccessFile inn = new RandomAccessFile(oldFile,"r");
		int i = 0;
		int j = 0;
		int max = 0;
		for(;j<number;j++){
			File outFile = new File(fdestFolderName + File.separator + oldFile.getName() + j + ".temp");
			RandomAccessFile outt = new RandomAccessFile(outFile,"rw");
			max += fsize;
			for(;i<max;i++){
				outt.write(inn.read());
			}
			outt.close();
		}
		
		File outFile = new File(fdestFolderName + File.separator + oldFile.getName() + j + ".temp");
		RandomAccessFile outt = new RandomAccessFile(outFile,"rw");
		//文件大小小于size时
		for(;i<fileLength;i++){
			outt.write(inn.read());
		}
		outt.close();
		inn.close();
		
	}
	
	/**
	 * 将分割后的文件合并
	 * @param fileName 合并之后的文件
	 * @param filterFolder 分割文件所在目录
	 * @param filterName 分割后的文件后缀
	 * @throws IOException
	 */
	public static void unite(String fileName,String filterFolder,final String filterName) throws IOException{
		File[] tt;
		File inFile = new File(filterFolder);
		File outFile = new File(fileName);
		RandomAccessFile outt = new RandomAccessFile(outFile,"rw");
		
		tt = inFile.listFiles(new FilenameFilter(){
			public boolean accept(File dir,String name){
				String rr = new File(name).toString();
				return rr.endsWith(filterName);
			}
		});
		
		for(int i = 0;i<tt.length;i++){
			RandomAccessFile inn = new RandomAccessFile(tt[i],"r");
			int c = 0;
			while((c=inn.read())!= -1){
				outt.write(c);
			}
			
		}
		outt.close();
		
	}
	


}
