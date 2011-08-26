package net.ysuga.firosophy.util;

import java.io.File;
import java.util.StringTokenizer;

public class FileNameUtil {

	private FileNameUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param parentPath 親のパス名．ファイル名は含まない
	 * @param child 子のファイルのフルパス．ファイル名は含む
	 * @return 子のファイルの相対パス．ファイル名は含む．相対パスの生成の失敗（たとえばWinシステムにおいて別ドライブのファイル）はnullを返す
	 */
	public static String getRelativePath(String parentPath, String child) {
		if(parentPath == null || child == null) return null;
		String separator;
		if(File.separator.equals("\\")) {
			separator = "\\\\";
		} else {
			separator = File.separator;
		}
		String[] parents = parentPath.split(separator);
		String[] childs  = child.split(separator);
				
		String retval = "";
		
		String fileSeparator = "/";
		int i = 0;
		while(true) {
			if(i == parents.length) {
				for( ; i < childs.length-1;i++) {
					retval += childs[i] + fileSeparator;
				}
				break;
			}
			
			if(i == childs.length-1) {
				for( ; i < parents.length;i++) {
					retval += ".." + fileSeparator;
				}
				break;
			}
			
			if(!parents[i].equals(childs[i])) {
				if(i == 0) { //最初から一致しなければ絶対パスにするしかない．
					return null;
				}
				
				for(int j = i;j < parents.length;j++) {
					retval += ".." + fileSeparator;
				}
				for(int j = i;j < childs.length-1;j++) {
					retval += childs + fileSeparator;
				}
				break;
			}
			
			i++;
		}

		retval += childs[childs.length-1];
		
		return retval;
	}

	public static String getAbsolutePath(String parentPath, String child) {
		String retval = "";
		String fileSeparator = "/";
		
		String separator;
		if(File.separator.equals("\\")) {
			separator = "\\\\";
		} else {
			separator = File.separator;
		}
		String[] parents = parentPath.split(separator);
		String[] childs  = child.split(fileSeparator);
		
		int parentLength = parents.length;
		
		for(int i = 0;i < childs.length;i++) {
			if(childs[i].equals("..")) {
				parentLength--;
			}
		}
		
		for(int i = 0;i < parentLength;i++) {
			retval += parents[i] + File.separator;
		}
		
		for(int i = 0;i < childs.length-1;i++) {
			if(!childs[i].equals("..")) {
				retval += childs[i] + File.separator;
			}
		}
		
		retval += childs[childs.length-1];
		
		return retval;
	}
}
