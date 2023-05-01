// pages/appoint/index.js
const app = getApp();
var util = require('../../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    appointDate: '',
    time: ''
  },

  changeDate(e){
    this.setData({
      appointDate: e.detail.value
    })
    this.getTime();
  },

  genderChange: function(e){

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      roomId: options.id,
      appointDate: util.formatDate(new Date())
    })

    this.getRoom()
    this.getTime()

  },

  changeDate(e){
    this.setData({
      appointDate: e.detail.value
    })
    this.getTime()
  },

  tabTime(e){
    var id = e.currentTarget.dataset.id;
    var time = e.currentTarget.dataset.starttime + "~" + e.currentTarget.dataset.endtime;
    this.setData({
      timeId: id,
      time: time
    })
  },

  getRoom: function () {
    var that = this;
    var roomId = this.data.roomId
    wx.request({
      url: app.globalData.domain + '/api/room/detail',
      data: {
        id: roomId
      },
      success: function (res) {
        that.setData({
          room: res.data.room,
        });
      }
    })

  },

  getTime(){
    var that = this;
    wx.showLoading({
    })
    wx.request({
      url: app.globalData.domain + '/api/time/list',
      data: {
        roomId: that.data.roomId,
        appointDate: that.data.appointDate
      },
      success: function (res) {
        that.setData({
          timeList: res.data.timeList
        })
      },
      complete: function (res) {
        wx.hideLoading({
        })
      }
    })
  },

  saveAppoint: function(e){
    if (!wx.getStorageSync('token')) {
      wx.navigateTo({
        url: '/pages/login/index',
      })
      return;
    }

    var that = this;
    var roomName = e.detail.value.roomName;
    var mobile = e.detail.value.mobile;
    var remark = e.detail.value.remark;
    var appointTime = this.data.appointDate;
    var roomId = this.data.roomId;
    var totalAmount = this.data.room.price;
    
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/order/save',
      header: {
        token: wx.getStorageSync('token')
      },
      method: "POST",
      data: {
        roomId: roomId,
        roomName: roomName,
        mobile: mobile,
        remark: remark,
        appointTime: appointTime,
        totalAmount: totalAmount,
        time: that.data.time,
        timeId: that.data.timeId
      },
      success: (res) => {
        if(res.data.code == 0){
          
          wx.navigateTo({
            url: '/pages/order/appoint-list/index?id=' + res.data.id,
          })
        }
      },
      complete: (res) => {
        wx.hideLoading();
      }
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