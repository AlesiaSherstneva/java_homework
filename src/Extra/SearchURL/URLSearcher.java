package Extra.SearchURL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLSearcher {
    public static void main(String[] args) {
        String input1 = """
                rhrthr https://stepik.org edtrhert r113223@12 https://wererwg.ru erwg3rg@123009https
                rhrthr http://sfrgeee.org/ewfef/wqewrg
                5476y65yyyyyh$%&$
                https://makedreamprofits.ru/?utm_source=ewqee&utm_medium=qew""";
        System.out.println("Sample Output 1:");
        findAllUrl(input1);

        String input2 = """
                kpb jwjd frv http://www.jqwmvnhu.gagzkxksp.ru/tmyp/?param0=ugtehajgg ior bsavmi
                elsdedejy blfesitfag udhyluxkj http://www.zhbh.kdokw.yapv.ru/xoihdn/ubs/?param0=pblsq&param1=wwqzb
                tmzwwo dmvlbwyvqv http://www.mppsuderi.rqt.com/ermuske/mldbhgy/?param0=bex hvcsgbl jrhbx gjtesiyyej pvj
                skphrki http://www.eccqkeoj.uttajvapi.hxnadj.com/?param0=hoi&param1=ssdd yykjd lob zlrsrzi xmmjbvle
                cpuymoqua http://www.zpy.witzxygk.ru hszud gzyvvhxqam crv zsy cuwjsruq https://www.ocdmnsdocx.xzsom.com
                nfwzfxllbe feesuhjemh zhhaigtoi https://www.osjum.sfzxcqblax.oqehtucjvd.com/?param0=sfcbfp&param1=sjnb""";
        System.out.println("Sample Output 2:");
        findAllUrl(input2);
    }

    private static void findAllUrl(String text) {
        Pattern pattern = Pattern.compile("http(s)?://\\w+\\.\\w{2,3}(\\S+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
