package net.ysuga.firosophy.util;

import java.io.File;
import java.util.StringTokenizer;

public class FileNameUtil {

	private FileNameUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param parentPath �e�̃p�X���D�t�@�C�����͊܂܂Ȃ�
	 * @param child �q�̃t�@�C���̃t���p�X�D�t�@�C�����͊܂�
	 * @return �q�̃t�@�C���̑��΃p�X�D�t�@�C�����͊܂ށD���΃p�X�̐����̎��s�i���Ƃ���Win�V�X�e���ɂ����ĕʃh���C�u�̃t�@�C���j��null��Ԃ�
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
				if(i == 0) { //�ŏ������v���Ȃ���ΐ�΃p�X�ɂ��邵���Ȃ��D
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
