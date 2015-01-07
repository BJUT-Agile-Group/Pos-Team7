package item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by joe on 15/1/6.
 */
public class Users implements Serializable {
    private String name;
    private String vip;
    private String code;
    private int score;

    public Users() {
    }


    public Users(String[] a) {
        setCode(a[0]);
        setName(a[1]);
        setVip(a[2]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void read(List<Users> user) {
        try {
            //读取用户会员信息
            BufferedReader bufferedReader = new BufferedReader(new FileReader("User.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    stringBuilder.append(data);
                }
            } while (data != null);
            data = stringBuilder.toString().replaceAll("\"name\"|\"isVip\"|':|',| |\n|\t|\\{|'|\"", "");
            String c[] = data.substring(0, data.length() - 2).split("},");
            for (String d : c) {
                Users users = new Users(d.split(":"));
                user.add(users);
            }

            //读取购物积分文件

            BufferedReader bufferedReader_ = new BufferedReader(new FileReader("UserScore.txt"));
            StringBuilder stringBuilder_ = new StringBuilder();
            String data_ = null;
            do {
                data_ = bufferedReader_.readLine();
                if (data_ != null) {
                    stringBuilder_.append(data_);
                }
            } while (data_ != null);
            data_ = stringBuilder_.toString().replaceAll("\"name\"|\"score\"|':|',| |\n|\t|\\{|'|\"", "");
            String c1[] = data_.substring(0, data_.length() - 2).split("},");
            for (String d : c1) {
                String c2[] = d.split(":");
                for (int n = 0; n < user.size(); n++) {
                    if (c2[1].equals(user.get(n).getName())) {
                        user.get(n).setScore(Integer.parseInt(c2[2]));
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
