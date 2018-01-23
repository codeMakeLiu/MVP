package com.example.lh.mvp.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lh on 2018/1/21.
 */

public class Book implements Serializable{

    /**
     * rating : {"max":10,"numRaters":14348,"average":"8.8","min":0}
     * subtitle : 硅谷创业之父Paul Graham文集
     * author : ["[美] Paul Graham"]
     * pubdate : 2011-4
     * tags : [{"count":7398,"name":"计算机","title":"计算机"},{"count":5837,"name":"互联网","title":"互联网"},{"count":5672,"name":"黑客","title":"黑客"},{"count":4376,"name":"创业","title":"创业"},{"count":2669,"name":"编程","title":"编程"},{"count":1196,"name":"阮一峰","title":"阮一峰"},{"count":1172,"name":"软件开发","title":"软件开发"},{"count":884,"name":"美国","title":"美国"}]
     * origin_title : Hackers and Painters: Big Ideas from the Computer Age
     * image : https://img3.doubanio.com/mpic/s4669554.jpg
     * binding : 平装
     * translator : ["阮一峰"]
     * catalog : 1  为什么书呆子不受欢迎	1
     他们的心思在别的地方。
     2  黑客与画家	18
     黑客也是创造者，与画家、建筑师、作家一样。
     3  不能说的话	34
     如果你的想法是社会无法容忍的，你怎么办？
     4  良好的坏习惯	52
     与其他美国人一样，黑客的成功秘诀就是打破常规。
     5  另一条路	59
     互联网软件是微机诞生后的最大机会。
     6  如何创造财富	90
     致富的最好方法就是为社会创造财富。创造财富的最好方法就是创业。
     7  关注贫富分化	111
     “收入分配不平等”的危害，会不会没有我们想的那样严重？
     8  防止垃圾邮件的一种方法	124
     不久前，许多专家还认为无法有效地过滤垃圾邮件。本文改变了他们的想法。
     9  设计者的品味	133
     如何做出优秀的东西？
     10  编程语言解析	148
     什么是编程语言？为什么它们现在很热门？
     11  一百年后的编程语言	156
     一百年后，人类怎样编程？为什么不从现在开始就这样编程呢？
     12  拒绝平庸	169
     别忘了你的对手与你一样，能用任何想用的语言编写互联网软件。
     13  书呆子的复仇	180
     在高科技行业，只有失败者采用“业界最佳实践”。
     14  梦寐以求的编程语言	198
     一种好的编程语言，是让黑客可以随心所欲使用的语言。
     15  设计与研究	213
     研究必须是“新”的，而设计必须是“好”的。
     志谢	219
     术语解释	221
     图片授权说明	236
     * ebook_url : https://read.douban.com/ebook/387525/
     * pages : 264
     * images : {"small":"https://img3.doubanio.com/spic/s4669554.jpg","large":"https://img3.doubanio.com/lpic/s4669554.jpg","medium":"https://img3.doubanio.com/mpic/s4669554.jpg"}
     * alt : https://book.douban.com/subject/6021440/
     * id : 6021440
     * publisher : 人民邮电出版社
     * isbn10 : 7115249490
     * isbn13 : 9787115249494
     * title : 黑客与画家
     * url : https://api.douban.com/v2/book/6021440
     * alt_title : Hackers and Painters: Big Ideas from the Computer Age
     * author_intro : 保罗•格雷厄姆，《黑客与画家》一书的作者，硅谷创业之父。1964年，出生于匹兹堡郊区的一个中产阶级家庭。父亲是设计核反应堆的物理学家，母亲在家照看他和他的妹妹。青少年时代，格雷厄姆就开始编程。但是，他还喜欢许多与计算机无关的东西，这在编程高手之中是很少见的。
     保罗•格雷厄姆在康奈尔大学读完本科，然后在哈佛大学获得计算机科学博士学位。1995年，他创办了Viaweb，帮助个人用户在网上开店，这是世界上第一个互联网应用程序。1998年夏天，Yahoo!公司收购了Viaweb，收购价约为5000万美元。
     此后，他架起了个人网站paulgraham.com，在上面撰写了许许多多关于软件和创业的文章，以深刻的见解和清晰的表达而著称，迅速引起了轰动。2005年，他身体力行，创建了风险投资公司Y Combinator，将自己的理论转化为实践，目前已经资助了80多家创业公司。现在，他是公认的互联网创业权威。
     * summary : 本书是硅谷创业之父Paul Graham 的文集，主要介绍黑客即优秀程序员的爱好和动机，讨论黑客成长、黑客对世界的贡献以及编程语言和黑客工作方法等所有对计算机时代感兴趣的人的一些话题。书中的内容不但有助于了解计算机编程的本质、互联网行业的规则，还会帮助读者了解我们这个时代，迫使读者独立思考。
     本书适合所有程序员和互联网创业者，也适合一切对计算机行业感兴趣的读者。
     * ebook_price : 12.00
     * price : 49.00元
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String ebook_url;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String ebook_price;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<String> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getEbook_url() {
        return ebook_url;
    }

    public void setEbook_url(String ebook_url) {
        this.ebook_url = ebook_url;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEbook_price() {
        return ebook_price;
    }

    public void setEbook_price(String ebook_price) {
        this.ebook_price = ebook_price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class RatingBean implements Serializable{
        /**
         * max : 10
         * numRaters : 14348
         * average : 8.8
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean implements Serializable{
        /**
         * small : https://img3.doubanio.com/spic/s4669554.jpg
         * large : https://img3.doubanio.com/lpic/s4669554.jpg
         * medium : https://img3.doubanio.com/mpic/s4669554.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class TagsBean implements Serializable{
        /**
         * count : 7398
         * name : 计算机
         * title : 计算机
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
