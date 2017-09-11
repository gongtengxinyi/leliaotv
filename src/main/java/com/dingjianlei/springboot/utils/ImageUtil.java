package com.dingjianlei.springboot.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

/**
 * 图片处理
 * 
 * @author lihome
 *
 */
public class ImageUtil {

    private static final Pattern imgPattern = Pattern.compile("\\.(png|jpeg|jpg|gif|bmp)$", Pattern.CASE_INSENSITIVE);
    
    public static final int THUMBNAIL_SIZE = 60;
    /**
     * 判断一个文件是否为图片
     * 
     * @param file
     * @return
     */
    public static boolean isImage(File file) {
        String fn = file.getName();
        return imgPattern.matcher(fn).find();
    }

    /**
     * Image -> BufferedImage
     * 
     * @param image
     * @return
     */
    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    /**
     * 获取缩略图名称
     * 
     * @param fileName
     * @return
     */
    public static String thumbnailFilename(String fileName) {
        String thumbnailSuffix = "_thumb";

        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return fileName + thumbnailSuffix;
        }

        return fileName.substring(0, dotIndex) + thumbnailSuffix//
                + fileName.substring(dotIndex);
    }

    /**
     * 生成缩略图
     * 
     * @param srcFile
     * @param distFile
     * @throws IOException
     */
    public static void thumbnail(File srcFile, File distFile, int width, int height) throws IOException {
        if (!ImageUtil.isImage(srcFile)) {
            return;
        }

        BufferedImage srcBuffImg = ImageIO.read(srcFile);
        Image img = srcBuffImg.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        ImageIO.write(ImageUtil.convertToBufferedImage(img), "png", distFile);
    }
}
