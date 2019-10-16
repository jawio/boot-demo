package cn.atofinon.cloud.freshman.lambdademo.data;

import lombok.Data;

/**
 * @Author atofinon
 * @Email yangjw@tuya.com
 * @Date 2019/10/16 4:51 PM
 * @Descrition
 */


@Data
public class UserVO {

    private String id;
    private String name;
    private Long time;


    public static UserVO fromDO(UserDO d) {
        UserVO vo = new UserVO();
        vo.setId(d.getId());
        vo.setName(d.getName());
        vo.setTime(d.getGmtCreate());

        return vo;
    }
}
