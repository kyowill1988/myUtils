package zlw80s.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	
	

}
