package com.dingjianlei.springboot.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageThread extends Thread {

	@Override
	public void run() {
		// 下载网页
		String URL = "http://comic.qq.com/pic/";
		// #focus > div:nth-child(3) > a > img
		Document document = null;
		try {
			document = (Document) Jsoup.connect(URL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 在下载的document里进行检索的语句
		Elements select = document.select("#focus").select("div:nth-child(3)").select("a").select("img");
		System.out.println(select);
		// 这样test标签就是我们最开始右键单击检查的标签

	}

	public static void main(String[] args) {
		// 下载网页
		String URL = "http://www.douyu.com/";
		// #focus > div:nth-child(3) > a > img #cmain > div.topBox > div.other >
		// table > tbody > tr:nth-child(2) > td > table > tbody >
		// tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(1) >
		// td > a
		Document document = null;
		try {
			document = (Document) Jsoup.connect(URL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// #m_239517 > div > div.c > div > div:nth-child(3) > div > div > a
		// 在下载的document里进行检索的语句
		Elements select = document.select("a");
		System.out.println(select);
		// 这样test标签就是我们最开始右键单击检查的标签
	}
}
