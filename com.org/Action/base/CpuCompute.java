package Action.base;

/**
 * 由于cpu一次取64个字节,也就是16个int,因此循环时+16跟挨个循环取的消耗是一样的
 * 且cpu计算很快,耗时还是在取数据,因此差别不大;
 * 当每次跳32个int时,实际上跨了一次取数据,因此速度差不多是1/2
 *
 * @author zll
 * @since 2021-08-09 11:59
 */
public class CpuCompute {
    public static void main(String[] args) {
        int[] temp = new int[64 * 1024 * 1024];
        long start = System.currentTimeMillis();
        for (int i = 0; i < temp.length; i++) {
            temp[i] += 1;
        }
        System.out.println("loop1 cost: " + (System.currentTimeMillis() - start));
        temp = new int[64 * 1024 * 1024];
        start = System.currentTimeMillis();
        for (int i = 0; i < temp.length; i += 32) {
            temp[i] += 1;
        }
        System.out.println("loop2 cost: " + (System.currentTimeMillis() - start));
    }


}
