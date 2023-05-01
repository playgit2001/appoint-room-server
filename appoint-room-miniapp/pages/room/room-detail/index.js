// pages/room/room-detail/index.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    autoplay: true,
    interval: 3000,
    duration: 1000,
    room: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getRoom(options.roomId);
  },

  getRoom: function (roomId) {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/room/detail',
      data: {
        id: roomId
      },
      success: function (res) {
        var room = res.data.room
        if(room.remark){
          room.remark = room.remark.replace(/\<img/g, "<img style='max-width: 100%;'")
        }
        that.setData({
          room: room,
        });
      }
    })

  },

  tapBuy: function(e){
    if (!wx.getStorageSync('token')) {
      wx.navigateTo({
        url: '/pages/login/index',
      })
      return;
    }

    var id = this.data.room.id;
    
    var roomList = [{
      id: this.data.room.id,
      roomName: this.data.room.roomName,
      picUrl: this.data.room.picUrl,
      num: 1,
      price: this.data.room.price
    }];
    wx.navigateTo({
      url: '/pages/order/appoint-time/index?id=' + id,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})