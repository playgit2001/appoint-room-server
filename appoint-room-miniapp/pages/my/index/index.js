const app = getApp()

Page({
  data: {
    list: [
      { "name": "我的信息", "url": "/pages/my/info/index" },
      { "name": "我的预约", "url": "/pages/order/appoint-list/index" }
    ]
  },

  onLoad() {

  },

  logout(){
    wx.removeStorage({
      key: 'token',
    })
    this.setData({
      member: null
    })
  },

  tabNav: function(e){
    var url = e.currentTarget.dataset.url;
    wx.navigateTo({
      url: url,
    })
  },

  onShow() {
    var token = wx.getStorageSync('token')
    if (!token) {
      return;
    }

    this.getMember();
  },

  /**
   * 查询用户信息
   */
  getMember: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/member/info',
      data: {
        token: wx.getStorageSync('token')
      },
      success: function (res) {
        if (res.data.code == 0) {
          that.setData({
            member: res.data.member
          })
        }
      }
    })
  },
  
  /**
   * 跳转登录
   */
  login: function(){
    wx.navigateTo({
      url: '/pages/login/index',
    })
  }

})