package cn.atofinon.cloud.freshman.lambdademo;

import cn.atofinon.cloud.freshman.lambdademo.data.UserDO;
import cn.atofinon.cloud.freshman.lambdademo.data.UserVO;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author atofinon
 * @Email yangjw@tuya.com
 * @Date 2019/10/16 4:46 PM
 * @Descrition
 */


public class MapDemo {

    public static void main(String[] args) {
        List<UserDO> dos = Lists.newArrayList();
        UserDO d1 = new UserDO();
        d1.setId("u1");
        d1.setName("jack");
        d1.setGmtCreate(11L);
        UserDO d2 = new UserDO();
        d2.setId("u2");
        d2.setName("bob");
        d2.setGmtCreate(2L);

        dos.add(d1);
        dos.add(d2);

        List<UserVO> vos = dos.parallelStream().map(t -> UserVO.fromDO(t)).sorted(Comparator.comparing(UserVO::getTime).reversed()).collect(Collectors.toList());
        vos.stream().forEach(System.out::println);
    }
}
