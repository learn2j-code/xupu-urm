package com.bjp.test;

import java.util.Arrays;
import java.util.List;

import com.bjp.constant.ClanConstant;

public class JavaTest {

	public static void main(String[] args) {
		String identity = "长子";
		List<String> sonKeyWordList = Arrays.asList( (ClanConstant.SONKEYWORD).split(ClanConstant.COMMA));
		List<String> daughterKeyWordList = Arrays.asList((ClanConstant.DAUGHTERWORD).split(ClanConstant.COMMA));
		List<String> husbandKeyWordList = Arrays.asList((ClanConstant.HUSBANDWORD).split(ClanConstant.COMMA));
		List<String> wifeKeyWordList = Arrays.asList((ClanConstant.WIFEKEYWORD).split(ClanConstant.COMMA));
		if(sonKeyWordList.contains(identity)||husbandKeyWordList.contains(identity)){
			System.out.println(ClanConstant.CLANMEMBERCONTENT_MALE);
		}
		if(daughterKeyWordList.contains(identity)||wifeKeyWordList.contains(identity)){
			System.out.println(ClanConstant.CLANMEMBERCONTENT_FEMALE);
		}

	}

}
