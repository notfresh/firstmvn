package person.notfresh;

public class Distance {

    /**
     * 根据两点之间的经纬度计算其距离
     * 参考自：
     * https://tech.meituan.com/2014/09/05/lucene-distance.html
     * lat1： 点p1的纬度
     *
     * 实际证明，这个代码计算出来的结果看不懂
     *
     * 获取某一个点的坐标
     * https://lbs.amap.com/tools/picker
     *
     *
     *
     * */
    public static double distHaversineRAD(double lat1, double lon1, double lat2, double lon2) {
        double hsinX = Math.sin((lon1 - lon2) * 0.5);
        double hsinY = Math.sin((lat1 - lat2) * 0.5);
        double h = hsinY * hsinY +
                (Math.cos(lat1) * Math.cos(lat2) * hsinX * hsinX);
        return 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h)) * 6367000;
    }

    /**
     * 角度转为弧度，
     * 一个地球上经纬度坐标为例，经度是该点与地心连线与本初子午线的夹角
     * 纬度是该点与地心连线与赤道的夹角
     *
     * */
    private static double rad(double d){
        return d * Math.PI / 180 ;
    }

    /**
     *
     * use this site to check the result https://www.box3.cn/tools/lbs.html
     * */
    public static double dis(double lat1, double lon1, double lat2, double lon2){
        double EARTH_RADIUS = 6371000;//赤道半径(单位m)
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);

        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double ret = 2 * Math.asin(Math.sqrt(
            Math.pow(Math.sin(a/2), 2) +
            Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b/2), 2)
        )) * EARTH_RADIUS;
        return ret;
    }
}

