package com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[][]  a={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
System.out.println(reconstructQueue(a));
	}
	  public static int[][] reconstructQueue(int[][] people) {
	        if (people == null || people.length == 0 || people[0].length == 0)
	            return new int[0][0];
	            
	        Arrays.sort(people, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                if (b[0] == a[0]) return a[1] - b[1];
	                return b[0] - a[0];
	            }
	        });
	 
	        //Arrays.asList(people).stream().forEach(s->System.out.println(s));
	        int n = people.length;
	        ArrayList<int[]> tmp = new ArrayList<int[]>();
	        //java.util.ArrayList.add(int index, E elemen) 方法将指定的元素E在此列表中的指定位置。
	        //它改变了目前元素在该位置(如果有的话)和所有后续元素向右移动(将添加一个到其索引)。
	        for (int i = 0; i < n; i++){
	        	//System.out.println(people[i][1]+"1:"+people[i][0]);
	            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
	        }
	        int[][] res = new int[people.length][2];
	        int i = 0;
	        for (int[] k : tmp) {
	            res[i][0] = k[0];
	            res[i++][1] = k[1];
	        }
	        System.out.println(Arrays.deepToString(res));
	        return res;
	    }

}
