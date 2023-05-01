// pages/project/project-detail/index.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    autoplay: true,
    interval: 3000,
    duration: 1000,
    project: {},
    projectNum: 0,
    shopCart: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    this.getProject(options.projectId);
    this.getEvaluation(options.projectId);
    var bookList = wx.getStorageSync("shopCart");
    if (bookList) {
      this.setData({
        projectNum: bookList.length
      })
    }
  },

  
  getEvaluation: function (projectId) {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/order/evaluation/list',
      data: {
        projectId: projectId
      },
      success: function (res) {
        that.setData({
          evaluations: res.data.evaluations
        })
      }
    })
  },


  getProject: function (projectId) {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/project/detail',
      data: {
        id: projectId
      },
      success: function (res) {
        that.setData({
          project: res.data.project,
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

    var id = this.data.project.id;
    
    var projectList = [{
      id: this.data.project.id,
      projectName: this.data.project.projectName,
      picUrl: this.data.project.picUrl,
      num: 1,
      price: this.data.project.price
    }];
    wx.navigateTo({
      url: '/pages/order/appoint/index?id=' + id,
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