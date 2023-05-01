var WxPay = require('../../../utils/pay.js')
var sliderWidth = 57.6; // 需要设置slider的宽度，用于计算中间位置
var app = getApp()
Page({
  data: {
    tabs: ["全部", "预约中", "已通过"],
    activeIndex: 0,
    statuses: ''
  },

  tabClick: function (e) {
    var that = this;
    this.setData({
      activeIndex: e.currentTarget.id,
      sliderOffset: e.currentTarget.offsetLeft,
      statuses: that.getStatus(e.currentTarget.id)
    });
    this.getOrderList();
  },

  toPay: function(e){
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/order/appoint-pay/index?id='+id,
    })
    return;
    var that = this;
    var totalAmount = e.currentTarget.dataset.totalamount;
    var appointNum = e.currentTarget.dataset.appointnum;
    WxPay.wxpay(app, totalAmount, appointNum, '商品购买', function (code) {
      // 
      if (code == 0) {
        that.getOrderList();
      }
    });
  },

  followUp: function (e) {
    var appointId = e.currentTarget.dataset.id;
    var that = this;
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/bms/appoint/followUp',
      data: {
        token: wx.getStorageSync('token'),
        storeId: app.globalData.storeId,
        appointId: appointId
      },
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          that.getOrderList();
        }
      }
    })
  },

  getStatus: function (activeIndex) {
    if (activeIndex == 0) {
      return '';
    } else if (activeIndex == 1) {
      return '1';
    } else if (activeIndex == 2) {
      return '2';
    } else if (activeIndex == 3) {
      return '3';
    } else if (activeIndex == 4) {
      return '4';
    }
  },

  appointDetail: function (e) {
    var appointId = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "/pages/appoint-details/index?id=" + appointId
    })
  },

  onLoad: function (options) {
    // 生命周期函数--监听页面加载
    var that = this;

    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
          sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
        });
      }
    });
  },

  getOrderList: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/order/list',
      data: {
        token: wx.getStorageSync('token'),
        status: that.data.statuses,
        appointType: 1
      },
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          that.setData({
            appointList: res.data.orderList
          });
        }
      }
    })
  },

  cancel: function (e) {
    var that = this;
    var totalAmount = e.currentTarget.dataset.totalamount;
    var appointNum = e.currentTarget.dataset.appointnum;
    var id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.domain + '/api/order/cancel',
      header:{
        token: wx.getStorageSync('token')
      },
      data: {id: id},
      success: (res) => {
        that.getOrderList();
      }
    })
  },

  confirm: function(e){
    var that = this;
    var appointNum = e.currentTarget.dataset.appointnum;
    var id = e.currentTarget.dataset.id;
    wx.request({
      url: app.globalData.domain + '/api/order/confirm',
      header: {
        token: wx.getStorageSync('token')
      },
      data: { id: id },
      success: (res) => {
        that.getOrderList();
      }
    })
  },

  evaluate: function (e) {
    var orderId = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/order/appoint-evaluate/index?orderId=' + orderId,
    })
  },

  onReady: function () {
    // 生命周期函数--监听页面初次渲染完成

  },

  onShow: function () {
    this.getOrderList();
  },
  onHide: function () {
    // 生命周期函数--监听页面隐藏

  },
  onUnload: function () {
    // 生命周期函数--监听页面卸载

  },
  onPullDownRefresh: function () {
    // 页面相关事件处理函数--监听用户下拉动作

  },
  onReachBottom: function () {
    // 页面上拉触底事件的处理函数

  },
  logistics: function(e){
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/shop/logistics/index?id=' + id,
    })
  }
})