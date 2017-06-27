package zlw80s.utils;

import java.io.File;
import java.util.Date;

public class FileUtil {
	
	/**
	 * 文件属性信息
	 * @param path
	 */
	public static void FileApplicationInfo(String path){
		
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
	public static void DeleteFile(File file){
		
		if(file.exists()){
			if(file.isFile()){
				
			}else if(file.isDirectory()){
				File[] files = file.listFiles();
				for(int i=0;i<files.length;i++){
					DeleteFile(files[i]);
				}
			}
			
			file.delete();
		}else{
			System.out.println("所要删除的文件不存在");
		}
	} 
	
}
