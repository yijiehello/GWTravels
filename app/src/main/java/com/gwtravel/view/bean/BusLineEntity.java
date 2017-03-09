package com.gwtravel.view.bean;

import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,9,0009.
 */

public class BusLineEntity {


    /**
     * msg : 000
     * code : 01
     * data : [{"marritalStatue":"","city":"武汉","loanMo":"4258637","companyName":null,"icon":"http://106.14.82.191/loan/static/html/cropped_1488245298021.jpg","userName":"图图","singleOrNot":"0","userId":"27","way":"2","LoanDetails":"","phone":"15869693223","companyAddress":null,"time":"2017-03-09 11:52:32","loanId":"122","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"80","companyName":null,"icon":"","userName":"路","singleOrNot":"0","userId":"82","way":"3","LoanDetails":"","phone":"","companyAddress":null,"time":"2017-03-06 16:35:13","loanId":"116","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"99999999","companyName":null,"icon":"","userName":"宋紫豪","singleOrNot":"0","userId":"83","way":"0","LoanDetails":"","phone":"13720163731","companyAddress":null,"time":"2017-03-06 16:13:38","loanId":"113","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"100000","companyName":null,"icon":"","userName":"张","singleOrNot":"0","userId":"77","way":"0","LoanDetails":"","phone":"","companyAddress":null,"time":"2017-03-06 15:49:11","loanId":"112","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"4948","companyName":"若无其事呜呜","icon":"http://106.14.82.191/loan/static/html/cropped_1488245298021.jpg","userName":"破跑一下西游记续","singleOrNot":"0","userId":"27","way":"","LoanDetails":"哦什么样了科学依据","phone":"15629037629","companyAddress":"水至清则无鱼","time":"2017-03-06 11:21:52","loanId":"107","status":"0","createDate":""},{"marritalStatue":"","city":"HANKOU","loanMo":"123123123","companyName":null,"icon":"http://106.14.82.191/loan/static/html/20170303105149.png","userName":"123123","singleOrNot":"0","userId":"25","way":"","LoanDetails":"Sdfsdfsdfsdfsdfdsfsdfsdfsdf","phone":"123123123123","companyAddress":null,"time":"2017-03-06 11:20:25","loanId":"106","status":"0","createDate":""},{"marritalStatue":"","city":"武汉市","loanMo":"120","companyName":null,"icon":"","userName":"熊推单","singleOrNot":"0","userId":"58","way":"0","LoanDetails":"","phone":"15000000000","companyAddress":null,"time":"2017-03-05 19:59:10","loanId":"97","status":"0","createDate":""},{"marritalStatue":"","city":"武汉市","loanMo":"120","companyName":null,"icon":"","userName":"熊提单","singleOrNot":"0","userId":"58","way":"3","LoanDetails":"","phone":"","companyAddress":null,"time":"2017-03-05 19:45:40","loanId":"96","status":"0","createDate":""},{"marritalStatue":"","city":"武汉市","loanMo":"120","companyName":null,"icon":"","userName":"推单熊","singleOrNot":"0","userId":"58","way":"0","LoanDetails":"","phone":"15000000000","companyAddress":null,"time":"2017-03-03 20:12:57","loanId":"94","status":"1","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"5000","companyName":null,"icon":"","userName":"孙凤云","singleOrNot":"0","userId":"57","way":"1","LoanDetails":"","phone":"15872033317","companyAddress":null,"time":"2017-03-03 18:31:42","loanId":"93","status":"3","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"120","companyName":null,"icon":"","userName":"信用推单","singleOrNot":"0","userId":"24","way":"2","LoanDetails":"","phone":"15000000000","companyAddress":null,"time":"2017-03-03 18:28:27","loanId":"92","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"120","companyName":null,"icon":"","userName":"担保推单X","singleOrNot":"0","userId":"24","way":"3","LoanDetails":"","phone":"15011111111","companyAddress":null,"time":"2017-03-03 18:27:22","loanId":"90","status":"2","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"120","companyName":"火星","icon":"","userName":"企业贷款","singleOrNot":"0","userId":"24","way":"","LoanDetails":"没钱","phone":"15027334698","companyAddress":"月球","time":"2017-03-03 18:23:25","loanId":"89","status":"0","createDate":""},{"marritalStatue":"","city":"武汉","loanMo":"1000","companyName":null,"icon":"","userName":"棒棒哒","singleOrNot":"0","userId":"57","way":"0","LoanDetails":"","phone":"13477092418","companyAddress":null,"time":"2017-03-03 18:02:09","loanId":"88","status":"1","createDate":""},{"marritalStatue":"","city":"武汉市","loanMo":"120","companyName":null,"icon":"","userName":"不X提单","singleOrNot":"0","userId":"58","way":"0","LoanDetails":"","phone":"","companyAddress":null,"time":"2017-03-03 17:47:48","loanId":"87","status":"2","createDate":""}]
     */

    private String msg;
    private String code;
    private List<Station> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Station> getData() {
        return data;
    }

    public void setData(List<Station> data) {
        this.data = data;
    }

    public static class Station {


        public Station(String name, String id) {
            this.name = name;
            this.id = id;
        }

        private String name;
        private String id;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
