package zlw80s.apps;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import zlw80s.utils.MathUtil;

/**
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  KNN.java   
 * @Package zlw80s.apps   
 * @Description: KNN算法
 * @author: willzh
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved.
 */
public class KNN {

	public static void main(String args[]) throws IOException{

		//生成样本
		List<Specimen> specimens = new ArrayList<>();		
		specimens.add(new Specimen("A",new Point(1,0)));
		specimens.add(new Specimen("A",new Point(2,4)));
		specimens.add(new Specimen("A",new Point(5,11)));
		specimens.add(new Specimen("A",new Point(12,14)));
		specimens.add(new Specimen("A",new Point(7,20)));
		specimens.add(new Specimen("B",new Point(5,5)));
		specimens.add(new Specimen("B",new Point(9,7)));
		specimens.add(new Specimen("B",new Point(10,6)));
		specimens.add(new Specimen("B",new Point(4,5)));
		specimens.add(new Specimen("B",new Point(16,10)));

		//目标坐标
		Scanner in=new Scanner(System.in);
		
		System.out.println("请输入X轴坐标");
		final int x = in.nextInt();
		System.out.println("请输入Y轴坐标");
		final int y = in.nextInt();
		
		Point targetPoint = new Point(x,y);

		List<Target> targets = new ArrayList<>();
		for(Specimen specimen :specimens){

			Target target = new Target();
			target.setKey(specimen.getTypeName());
			target.setDistance(MathUtil.distince(specimen.getCoordinate().getX()
					, specimen.getCoordinate().getY()
					, targetPoint.getX()
					, targetPoint.getY()));
			target.setPoint(specimen.getCoordinate());			
			targets.add(target);			
		}

		//赋K值
		System.out.println("请输入K值");
		final int k = in.nextInt();
		
		List<Target> topK = targets.stream()
				.sorted(Comparator.comparing(Target::getDistance))
				.limit(k)
				.collect(toList());
		
		//结果比较打印
		System.out.println("======样本=======");
		System.out.println("样本数："+specimens.stream().count());
		specimens.forEach(r-> System.out.println("坐标 x="+ r.getCoordinate().getX() +" y= " + r.getCoordinate().getY() +" 类别：" + r.getTypeName()));
		System.out.println("======输入项======");
		System.out.println("您输入的坐标为：x="+targetPoint.getX()+" y=" + targetPoint.getY());
		System.out.println("您输入的K值为：x="+k);
		System.out.println("======处理中=======");
		topK.forEach(r->System.out.println("坐标 x="+ r.getPoint().getX() +" y= " + r.getPoint().getY()+" 类别 "+r.getKey()+"距离 "+r.getDistance()));		
		System.out.println("=======结果======");
		
		long countA = topK.stream().filter(r->r.getKey()=="A").count();
		long countB = topK.stream().filter(r->r.getKey()=="B").count();
		if(countA < countB){
			System.out.println("类别为：B");
		}else{
			System.out.println("类别为：A");
		}

	}


}
