package cn.peyton.core.img;

import cn.peyton.core.toolkit.LogTools;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * <h3>图片操作类</h3>
 *
 * @author Peyton_YU
 * @Title: ImageOperate.java
 * @Package cn.peyton.wanzibaidai.ext.img
 * @ClassName: ImageOperate
 * @date 2017年10月6日 下午4:53:53
 */
@SuppressWarnings("ALL")
public final class ImageOperation {

    /**
     * <h3>对图片裁剪，并把裁剪新图片保存</h3>
     *
     * @param srcPath          读取源图片路径
     * @param toPath           写入图片路径
     * @param x                剪切起始点x坐标
     * @param y                剪切起始点y坐标
     * @param width            剪切宽度
     * @param height           剪切高度
     * @param readImageFormat  读取图片格式
     * @param writeImageFormat 写入图片格式
     * @throws IOException
     */
    public void cropImage(String srcPath, String toPath, int x, int y, int width, int height,
                          String readImageFormat, String writeImageFormat) throws IOException {
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            // 读取图片文件
            fis = new FileInputStream(srcPath);
            Iterator<?> it = ImageIO.getImageReadersByFormatName(readImageFormat);
            ImageReader reader = (ImageReader) it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            // 定义一个矩形
            Rectangle rect = new Rectangle(x, y, width, height);
            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            // 保存新图片
            ImageIO.write(bi, writeImageFormat, new File(toPath));
        } catch (Exception e){
            LogTools.error(e.getMessage());
        }finally {
            if (fis != null) {
                fis.close();
            }
            if (iis != null) {
                iis.close();
            }
        }
    }

    /**
     * 按倍率缩小图片
     *
     * @param srcImagePath 读取图片路径
     * @param toImagePath  写入图片路径
     * @param widthRatio   宽度缩小比例
     * @param heightRatio  高度缩小比例
     * @throws IOException
     */
    public void reduceImageByRatio(String srcImagePath, String toImagePath, int widthRatio, int heightRatio)
            throws IOException {
        try {
            // 读入文件
            File file = new File(srcImagePath);
            // 构造Image对象
            BufferedImage src = ImageIO.read(file);
            insideReduceImageEqualProportion(src, toImagePath, widthRatio, heightRatio);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 按倍率缩小图片
     *
     * @param multipartFile multipartFile对象
     * @param toImagePath   写入图片路径
     * @param widthRatio    宽度缩小比例
     * @param heightRatio   高度缩小比例
     * @throws IOException
     */
    public void reduceImageByRatio(MultipartFile multipartFile, String toImagePath, int widthRatio, int heightRatio){
        try {
            insideReduceImageEqualProportion(ImageIO.read(multipartFile.getInputStream()), toImagePath, widthRatio, heightRatio);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 长高等比例缩小图片
     *
     * @param srcImagePath 读取图片路径
     * @param toImagePath  写入图片路径
     * @param ratio        缩小比例
     * @throws IOException
     */
    public void reduceImageEqualProportion(String srcImagePath, String toImagePath,
                                           int ratio) throws IOException {
        try {
            // 读入文件
            File file = new File(srcImagePath);
            // 构造Image对象
            BufferedImage src = ImageIO.read(file);
            insideReduceImageEqualProportion(src, toImagePath, ratio, ratio);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 长高等比例缩小图片
     *
     * @param toImagePath 写入图片路径
     * @param ratio       缩小比例
     * @throws IOException
     */
    public void reduceImageEqualProportion(MultipartFile multipartFile, String toImagePath,
                                           int ratio) throws IOException {
        try {
            insideReduceImageEqualProportion(ImageIO.read(multipartFile.getInputStream()), toImagePath, ratio, ratio);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * <h4>按比率缩放图片</h4>
     *
     * @param src
     * @param toImagePath
     * @param widthRatio
     * @param heightRatio
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void insideReduceImageEqualProportion(BufferedImage src, String toImagePath,
                                                  int widthRatio, int heightRatio) throws FileNotFoundException, IOException {
        int width = src.getWidth();
        int height = src.getHeight();
        // 缩小边长
        BufferedImage tag = new BufferedImage(width / widthRatio, height / heightRatio, BufferedImage.TYPE_INT_RGB);
        // 绘制 缩小 后的图片
        tag.getGraphics().drawImage(src, 0, 0, width / widthRatio, height / heightRatio, null);

        ImageIO.write(tag, "JPEG", new FileOutputStream(toImagePath));
    }

    /**
     * 按倍率放大图片
     *
     * @param srcImagePath 读取图形路径
     * @param toImagePath  写入入行路径
     * @param widthRatio   宽度放大比例
     * @param heightRatio  高度放大比例
     * @throws IOException
     */
    public void enlargementImageByRatio(String srcImagePath, String toImagePath, int widthRatio, int heightRatio)
            throws IOException {
        FileOutputStream out = null;
        try {
            // 读入文件
            File file = new File(srcImagePath);
            // 构造Image对象
            BufferedImage src = ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 放大边长
            BufferedImage tag = new BufferedImage(width * widthRatio, height * heightRatio, BufferedImage.TYPE_INT_RGB);
            // 绘制放大后的图片
            tag.getGraphics().drawImage(src, 0, 0, width * widthRatio, height * heightRatio, null);
            out = new FileOutputStream(toImagePath);
            ImageIO.write(tag, "JPEG", out);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 长高等比例放大图片
     *
     * @param srcImagePath 读取图形路径
     * @param toImagePath  写入入行路径
     * @param ratio        放大比例
     * @throws IOException
     */
    public void enlargementImageEqualProportion(String srcImagePath, String toImagePath, int ratio) throws IOException {
        FileOutputStream out = null;
        try {
            // 读入文件
            File file = new File(srcImagePath);
            // 构造Image对象
            BufferedImage src = ImageIO.read(file);
            int width = src.getWidth();
            int height = src.getHeight();
            // 放大边长
            BufferedImage tag = new BufferedImage(width * ratio, height * ratio, BufferedImage.TYPE_INT_RGB);
            // 绘制放大后的图片
            tag.getGraphics().drawImage(src, 0, 0, width * ratio, height * ratio, null);
            out = new FileOutputStream(toImagePath);
            ImageIO.write(tag, "JPEG", out);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 重置图形的边长大小
     *
     * @param srcImagePath
     * @param toImagePath
     * @param width
     * @param height
     * @throws IOException
     */
    public void resizeImage(String srcImagePath, String toImagePath, int width, int height) throws IOException {
        FileOutputStream out = null;
        try {
            // 读入文件
            File file = new File(srcImagePath);
            // 构造Image对象
            BufferedImage src = ImageIO.read(file);
            // 放大边长
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            // 绘制放大后的图片
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);
            out = new FileOutputStream(toImagePath);
            ImageIO.write(tag, "JPEG", out);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 横向拼接图片（两张）
     *
     * @param firstSrcImagePath  第一张图片的路径
     * @param secondSrcImagePath 第二张图片的路径
     * @param imageFormat        拼接生成图片的格式
     * @param toPath             拼接生成图片的路径
     */
    public void joinImagesHorizontal(String firstSrcImagePath, String secondSrcImagePath, String imageFormat,
                                     String toPath) {
        try {
            // 读取第一张图片
            File fileOne = new File(firstSrcImagePath);
            BufferedImage imageOne = ImageIO.read(fileOne);
            // 图片宽度
            int width = imageOne.getWidth();
            // 图片高度
            int height = imageOne.getHeight();
            // 从图片中读取RGB
            int[] imageArrayOne = new int[width * height];
            imageArrayOne = imageOne.getRGB(0, 0, width, height, imageArrayOne, 0, width);

            // 对第二张图片做相同的处理
            File fileTwo = new File(secondSrcImagePath);
            BufferedImage imageTwo = ImageIO.read(fileTwo);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[] imageArrayTwo = new int[width2 * height2];
            imageArrayTwo = imageTwo.getRGB(0, 0, width, height, imageArrayTwo, 0, width);

            // 生成新图片
            BufferedImage imageNew = new BufferedImage(width * 2, height, BufferedImage.TYPE_INT_RGB);
            // 设置左半部分的RGB
            imageNew.setRGB(0, 0, width, height, imageArrayOne, 0, width);
            // 设置右半部分的RGB
            imageNew.setRGB(width, 0, width, height, imageArrayTwo, 0, width);

            File outFile = new File(toPath);
            // 写图片
            ImageIO.write(imageNew, imageFormat, outFile);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 横向拼接一组（多张）图像
     *
     * @param pics   将要拼接的图像
     * @param type   图像写入格式
     * @param dstPic 图像写入路径
     * @return
     */
    public boolean joinImageListHorizontal(String[] pics, String type, String dstPic) {
        try {
            int len = pics.length;
            if (len < 1) {
                System.out.println("pics len < 1");
                return false;
            }
            File[] src = new File[len];
            BufferedImage[] images = new BufferedImage[len];
            int[][] imageArrays = new int[len][];
            for (int i = 0; i < len; i++) {
                src[i] = new File(pics[i]);
                images[i] = ImageIO.read(src[i]);
                int width = images[i].getWidth();
                int height = images[i].getHeight();
                // 从图片中读取RGB
                imageArrays[i] = new int[width * height];
                imageArrays[i] = images[i].getRGB(0, 0, width, height, imageArrays[i], 0, width);
            }

            int dstWidth = 0;
            int dstHeight = images[0].getHeight();
            for (int i = 0; i < images.length; i++) {
                dstHeight = dstHeight > images[i].getHeight() ? dstHeight : images[i].getHeight();
                dstWidth += images[i].getWidth();
            }
            if (dstHeight < 1) {
                System.out.println("dst_height < 1");
                return false;
            }
            // 生成新图片
            BufferedImage imageNew = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_RGB);
            int widthImg = 0;
            for (int i = 0; i < images.length; i++) {
                imageNew.setRGB(widthImg, 0, images[i].getWidth(), dstHeight, imageArrays[i], 0, images[i].getWidth());
                widthImg += images[i].getWidth();
            }
            File outFile = new File(dstPic);
            // 写图片
            ImageIO.write(imageNew, type, outFile);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 纵向拼接图片（两张）
     *
     * @param firstSrcImagePath  读取的第一张图片
     * @param secondSrcImagePath 读取的第二张图片
     * @param imageFormat        图片写入格式
     * @param toPath             图片写入路径
     */
    public void joinImagesVertical(String firstSrcImagePath, String secondSrcImagePath, String imageFormat,
                                   String toPath) {
        try {
            // 读取第一张图片
            File fileOne = new File(firstSrcImagePath);
            BufferedImage imageOne = ImageIO.read(fileOne);
            // 图片宽度
            int width = imageOne.getWidth();
            // 图片高度
            int height = imageOne.getHeight();
            // 从图片中读取RGB
            int[] imageArrayOne = new int[width * height];
            imageArrayOne = imageOne.getRGB(0, 0, width, height, imageArrayOne, 0, width);

            // 对第二张图片做相同的处理
            File fileTwo = new File(secondSrcImagePath);
            BufferedImage imageTwo = ImageIO.read(fileTwo);
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[] imageArrayTwo = new int[width2 * height2];
            imageArrayTwo = imageTwo.getRGB(0, 0, width, height, imageArrayTwo, 0, width);

            // 生成新图片
            BufferedImage imageNew = new BufferedImage(width, height * 2, BufferedImage.TYPE_INT_RGB);
            // 设置上半部分的RGB
            imageNew.setRGB(0, 0, width, height, imageArrayOne, 0, width);
            // 设置下半部分的RGB
            imageNew.setRGB(0, height, width, height, imageArrayTwo, 0, width);

            File outFile = new File(toPath);
            // 写图片
            ImageIO.write(imageNew, imageFormat, outFile);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 纵向拼接一组（多张）图像
     *
     * @param pics   将要拼接的图像数组
     * @param type   写入图像类型
     * @param dstPic 写入图像路径
     * @return
     */
    public boolean joinImageListVertical(String[] pics, String type, String dstPic) {
        try {
            int len = pics.length;
            if (len < 1) {
                System.out.println("pics len < 1");
                return false;
            }
            File[] src = new File[len];
            BufferedImage[] images = new BufferedImage[len];
            int[][] imageArrays = new int[len][];
            for (int i = 0; i < len; i++) {
                src[i] = new File(pics[i]);
                images[i] = ImageIO.read(src[i]);
                int width = images[i].getWidth();
                int height = images[i].getHeight();
                // 从图片中读取RGB
                imageArrays[i] = new int[width * height];
                imageArrays[i] = images[i].getRGB(0, 0, width, height, imageArrays[i], 0, width);
            }

            int dstHeight = 0;
            int dstWidth = images[0].getWidth();
            for (int i = 0; i < images.length; i++) {
                dstWidth = dstWidth > images[i].getWidth() ? dstWidth : images[i].getWidth();
                dstHeight += images[i].getHeight();
            }
            if (dstHeight < 1) {
                System.out.println("dst_height < 1");
                return false;
            }
            // 生成新图片
            BufferedImage imageNew = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_RGB);
            int heightImg = 0;
            for (int i = 0; i < images.length; i++) {
                imageNew.setRGB(0, heightImg, dstWidth, images[i].getHeight(), imageArrays[i], 0, dstWidth);
                heightImg += images[i].getHeight();
            }
            File outFile = new File(dstPic);
            // 写图片
            ImageIO.write(imageNew, type, outFile);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 合并图片(按指定初始x、y坐标将附加图片贴到底图之上)
     *
     * @param negativeImagePath 背景图片路径
     * @param additionImagePath 附加图片路径
     * @param x                 附加图片的起始点x坐标
     * @param y                 附加图片的起始点y坐标
     * @param toPath            图片写入路径
     * @throws IOException
     */
    public void mergeBothImage(String negativeImagePath, String additionImagePath, int x, int y, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, x, y, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将一组图片一次性附加合并到底图上
     *
     * @param negativeImagePath 源图像（底图）路径
     * @param additionImageList 附加图像信息列表
     * @param imageFormat       图像写入格式
     * @param toPath            图像写入路径
     * @throws IOException
     */
    public void mergeImageList(String negativeImagePath, List<?> additionImageList, String imageFormat, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            BufferedImage image = ImageIO.read(is);
            Graphics2D g = image.createGraphics();

            BufferedImage image2 = null;
            if (additionImageList != null) {
                for (int i = 0; i < additionImageList.size(); i++) {
                    // 解析附加图片信息：x坐标、 y坐标、 additionImagePath附加图片路径
                    // 图片信息存储在一个数组中
                    String[] additionImageInfo = (String[]) additionImageList.get(i);
                    int x = Integer.parseInt(additionImageInfo[0]);
                    int y = Integer.parseInt(additionImageInfo[1]);
                    String additionImagePath = additionImageInfo[2];
                    // 读取文件输入流，并合并图片
                    is2 = new FileInputStream(additionImagePath);
                    image2 = ImageIO.read(is2);
                    g.drawImage(image2, x, y, null);
                }
            }
            os = new FileOutputStream(toPath);
            // 写图片
            ImageIO.write(image, imageFormat, os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的左上角
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageTopleftcorner(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, 0, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的右上角
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageToprightcorner(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), 0, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的左下角
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageLeftbottom(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, image.getHeight() - image2.getHeight(), null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的左下角
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageRightbottom(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), image.getHeight() - image2.getHeight(), null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的正中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageCenter(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2,
                    image.getHeight() / 2 - image2.getHeight() / 2, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的上边中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageTopcenter(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2, 0, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的下边中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageBottomcenter(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() / 2 - image2.getWidth() / 2, image.getHeight() - image2.getHeight(),
                    null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的左边中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageLeftcenter(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 0, image.getHeight() / 2 - image2.getHeight() / 2, null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将附加图片合并到底图的右边中央
     *
     * @param negativeImagePath 底图路径
     * @param additionImagePath 附加图片路径
     * @param toPath            合成图片写入路径
     * @throws IOException
     */
    public void mergeBothImageRightcenter(String negativeImagePath, String additionImagePath, String toPath)
            throws IOException {
        InputStream is = null;
        InputStream is2 = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(negativeImagePath);
            is2 = new FileInputStream(additionImagePath);
            BufferedImage image = ImageIO.read(is);
            BufferedImage image2 = ImageIO.read(is2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, image.getWidth() - image2.getWidth(), image.getHeight() / 2 - image2.getHeight() / 2,
                    null);
            os = new FileOutputStream(toPath);
            ImageIO.write(image, "JPEG", os);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (os != null) {
                os.close();
            }
            if (is2 != null) {
                is2.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 图片灰化操作
     *
     * @param srcImage    读取图片路径
     * @param toPath      写入灰化后的图片路径
     * @param imageFormat 图片写入格式
     */
    public void grayImage(String srcImage, String toPath, String imageFormat) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImage));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, imageFormat, new File(toPath));
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        }
    }

    /**
     * 在源图片上设置水印文字
     *
     * @param srcImagePath 源图片路径
     * @param alpha        透明度（0<alpha<1）
     * @param font         字体（例如：宋体）
     * @param fontStyle    字体格式(例如：普通样式--Font.PLAIN、粗体--Font.BOLD )
     * @param fontSize     字体大小
     * @param color        字体颜色(例如：黑色--Color.BLACK)
     * @param inputWords   输入显示在图片上的文字
     * @param x            文字显示起始的x坐标
     * @param y            文字显示起始的y坐标
     * @param imageFormat  写入图片格式（png/jpg等）
     * @param toPath       写入图片路径
     * @throws IOException
     */
    public void alphaWords2Image(String srcImagePath, float alpha, String font, int fontStyle, int fontSize,
                                 Color color, String inputWords, int x, int y, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 创建java2D对象
            Graphics2D g2d = image.createGraphics();
            // 用源图像填充背景
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            // 设置透明度
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            // 设置文字字体名称、样式、大小
            g2d.setFont(new Font(font, fontStyle, fontSize));
            // 设置字体颜色
            g2d.setColor(color);
            // 输入水印文字及其起始x、y坐标
            g2d.drawString(inputWords, x, y);
            g2d.dispose();
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 在源图像上设置图片水印 ---- 当alpha==1时文字不透明（和在图片上直接输入文字效果一样）
     *
     * @param srcImagePath    源图片路径
     * @param appendImagePath 水印图片路径
     * @param alpha           透明度
     * @param x               水印图片的起始x坐标
     * @param y               水印图片的起始y坐标
     * @param width           水印图片的宽度
     * @param height          水印图片的高度
     * @param imageFormat     图像写入图片格式
     * @param toPath          图像写入路径
     * @throws IOException
     */
    public void alphaImage2Image(String srcImagePath, String appendImagePath, float alpha, int x, int y, int width,
                                 int height, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 创建java2D对象
            Graphics2D g2d = image.createGraphics();
            // 用源图像填充背景
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            // 设置透明度
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            // 设置水印图片的起始x/y坐标、宽度、高度
            BufferedImage appendImage = ImageIO.read(new File(appendImagePath));
            g2d.drawImage(appendImage, x, y, width, height, null, null);
            g2d.dispose();
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 画单点 ---- 实际上是画一个填充颜色的圆 ---- 以指定点坐标为中心画一个小半径的圆形，并填充其颜色来充当点
     *
     * @param srcImagePath 源图片颜色
     * @param x            点的x坐标
     * @param y            点的y坐标
     * @param width        填充的宽度
     * @param height       填充的高度
     * @param ovalColor    填充颜色
     * @param imageFormat  写入图片格式
     * @param toPath       写入路径
     * @throws IOException
     */
    public void drawPoint(String srcImagePath, int x, int y, int width, int height, Color ovalColor, String imageFormat,
                          String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取源图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制连接线
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(ovalColor);
            // 填充一个椭圆形
            g2d.fillOval(x, y, width, height);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 画一组（多个）点---- 实际上是画一组（多个）填充颜色的圆 ---- 以指定点坐标为中心画一个小半径的圆形，并填充其颜色来充当点
     *
     * @param srcImagePath 原图片路径
     * @param pointList    点列表
     * @param width        宽度
     * @param height       高度
     * @param ovalColor    填充颜色
     * @param imageFormat  写入图片颜色
     * @param toPath       写入路径
     * @throws IOException
     */
    public void drawPoints(String srcImagePath, List<?> pointList, int width, int height, Color ovalColor,
                           String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取源图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制连接线
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(ovalColor);
            // 填充一个椭圆形
            if (pointList != null) {
                for (int i = 0; i < pointList.size(); i++) {
                    Point point = (Point) pointList.get(i);
                    int x = (int) point.getX();
                    int y = (int) point.getY();
                    g2d.fillOval(x, y, width, height);
                }
            }
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 画线段
     *
     * @param srcImagePath 源图片路径
     * @param x1           第一个点x坐标
     * @param y1           第一个点y坐标
     * @param x2           第二个点x坐标
     * @param y2           第二个点y坐标
     * @param lineColor    线条颜色
     * @param toPath       图像写入路径
     * @param imageFormat  图像写入格式
     * @throws IOException
     */
    public void drawLine(String srcImagePath, int x1, int y1, int x2, int y2, Color lineColor, String toPath,
                         String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取源图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制连接线
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(lineColor);
            g2d.drawLine(x1, y1, x2, y2);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 画折线 / 线段 ---- 2个点即画线段，多个点画折线
     *
     * @param srcImagePath 源图片路径
     * @param xPoints      x坐标数组
     * @param yPoints      y坐标数组
     * @param nPoints      点的数量
     * @param lineColor    线条颜色
     * @param toPath       图像写入路径
     * @param imageFormat  图片写入格式
     * @throws IOException
     */
    public void drawPolyline(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color lineColor,
                             String toPath, String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取源图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制连接线
            Graphics2D g2d = image.createGraphics();
            // 设置线条颜色
            g2d.setColor(lineColor);
            g2d.drawPolyline(xPoints, yPoints, nPoints);
            // 图像写出路径
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 绘制折线，并突出显示转折点
     *
     * @param srcImagePath 源图片路径
     * @param xPoints      x坐标数组
     * @param yPoints      y坐标数组
     * @param nPoints      点的数量
     * @param lineColor    连线颜色
     * @param width        点的宽度
     * @param height       点的高度
     * @param ovalColor    点的填充颜色
     * @param toPath       图像写入路径
     * @param imageFormat  图像写入格式
     * @throws IOException
     */
    public void drawPolylineShowPoints(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color lineColor,
                                       int width, int height, Color ovalColor, String toPath, String imageFormat) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取源图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制连接线
            Graphics2D g2d = image.createGraphics();
            // 设置线条颜色
            g2d.setColor(lineColor);
            // 画线条
            g2d.drawPolyline(xPoints, yPoints, nPoints);
            // 设置圆点颜色
            g2d.setColor(ovalColor);
            // 画圆点
            if (xPoints != null) {
                for (int i = 0; i < xPoints.length; i++) {
                    int x = xPoints[i];
                    int y = yPoints[i];
                    g2d.fillOval(x, y, width, height);
                }
            }
            // 图像写出路径
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
        } catch (IOException e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 绘制一个由 x 和 y 坐标数组定义的闭合多边形
     *
     * @param srcImagePath 源图片路径
     * @param xPoints      x坐标数组
     * @param yPoints      y坐标数组
     * @param nPoints      坐标点的个数
     * @param polygonColor 线条颜色
     * @param imageFormat  图像写入格式
     * @param toPath       图像写入路径
     * @throws IOException
     */
    public void drawPolygon(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color polygonColor,
                            String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制闭合多边形
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(polygonColor);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
            g2d.dispose();
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 绘制并填充多边形
     *
     * @param srcImagePath 源图像路径
     * @param xPoints      x坐标数组
     * @param yPoints      y坐标数组
     * @param nPoints      坐标点个数
     * @param polygonColor 多边形填充颜色
     * @param alpha        多边形部分透明度
     * @param imageFormat  写入图形格式
     * @param toPath       写入图形路径
     * @throws IOException
     */
    public void drawAndAlphaPolygon(String srcImagePath, int[] xPoints, int[] yPoints, int nPoints, Color polygonColor,
                                    float alpha, String imageFormat, String toPath) throws IOException {
        FileOutputStream fos = null;
        try {
            // 获取图片
            BufferedImage image = ImageIO.read(new File(srcImagePath));
            // 根据xy点坐标绘制闭合多边形
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(polygonColor);
            // 设置透明度
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(ac);
            g2d.fillPolygon(xPoints, yPoints, nPoints);
            fos = new FileOutputStream(toPath);
            ImageIO.write(image, imageFormat, fos);
            g2d.dispose();
        } catch (Exception e) {
            LogTools.error(e.getMessage());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}
