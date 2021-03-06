package com.liujun.search.engine.analyze.operation.htmlanalyze.process.spitword.loader;

import com.liujun.search.algorithm.ahoCorasick.pojo.MatcherBusi;
import com.liujun.search.algorithm.trieTree.TrieTreeChina;
import org.junit.Assert;
import org.junit.Test;

/**
 * 进行分词的测试
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/04/22
 */
public class TestTrideTreeWord {

  @Test
  public void testTrideTree() {
    long startTime = System.currentTimeMillis();
    TrieTreeChina chinaChar = TrieTreeWord.INSTANCE.getSpitWord();
    long endTime = System.currentTimeMillis();

    System.out.println("用时:" + (endTime - startTime));

    StringBuilder testFile = new StringBuilder();
    testFile.append("goddaughter");
    testFile.append("贝林克拟四须魮");
    testFile.append("资产评估");
    testFile.append("珠海国际赛车场");
    testFile.append("大手大脚");
    testFile.append("心病还须心药医");
    testFile.append("大秦回族乡");
    testFile.append("口镇顺香斋南肠");
    testFile.append("自然语言语法");
    testFile.append("云南省保守国家秘密若干规定");
    testFile.append("折笠富美子");
    testFile.append("医学纲目");
    testFile.append("与高适薛据登慈恩寺浮图");
    testFile.append("不将颜色托春风");

    char[] charWords = testFile.toString().toCharArray();

    int start = 0;
    while (true) {
      MatcherBusi busi = chinaChar.match(charWords, start);

      if (busi.getMatcherIndex() != -1) {
        System.out.println("匹配:" + busi.getMatcherKey());
        Assert.assertNotNull(busi.getMatcherKey());
        start = busi.getMatcherIndex() + busi.getMatcherKey().length();
      } else {
        break;
      }
    }
  }
}
