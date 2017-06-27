package zlw80s.utils;

import java.io.File;
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
	
	public static long getDirSize(File file){
		
		long size = 0;
		size = getDirItemSize(file,size);
		return size;
	}
	
	/**
	 * 获取文件夹大小
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
	
	

}
