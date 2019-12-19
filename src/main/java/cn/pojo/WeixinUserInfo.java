package cn.pojo;

import org.springframework.stereotype.Component;

@Component("weixinUserInfo")
public class WeixinUserInfo {
	private Integer id;
	private String openId;// 用户的标识
	private Integer subscribe;// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
	private String subscribeTime;// 用户关注时间
	private String nickname;// 昵称
	private Integer sex;// 用户的性别（1是男性，2是女性，0是未知）
	private String country;// 用户所在国家
	private String province;// 用户所在省份
	private String city;// 用户所在城市
	private String language;// 用户的语言，简体中文为zh_CN
	private String groupid;// 用户所在的分组ID
	private String headImgUrl;// 用户头像

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	@Override
	public String toString() {
		return "WeixinUserInfo [id=" + id + ", openId=" + openId + ", subscribe=" + subscribe + ", subscribeTime="
				+ subscribeTime + ", nickname=" + nickname + ", sex=" + sex + ", country=" + country + ", province="
				+ province + ", city=" + city + ", language=" + language + ", groupid=" + groupid + ", headImgUrl="
				+ headImgUrl + "]";
	}

}
