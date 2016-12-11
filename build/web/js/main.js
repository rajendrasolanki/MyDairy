var app=angular.module("MyApp",["ngRoute"]);
app.config(function($routeProvider){
    $routeProvider
    .when("/",{
        template:"<h1>Wel-Come</h1><div class='subBox'><a href='#MyFnd/myfnd'> My Friend </a></div>"+
                "<div class='subBox'><a href='#MyFam/myfam'> My Family </a></div>"+
                "<div class='subBox'><a href='#MyColl/mycoll'> My Colleagues </a></div>"+
                "<div class='subBox'><a href='#MyClgFnd/myclgfnd'> My College Friend </a></div>"
    }).when("/MyFnd/:table",{
        templateUrl:"list.jsp"
    }).when("/MyFam/:table",{
        templateUrl:"list.jsp"
    }).when("/MyColl/:table",{
        templateUrl:"list.jsp"
    }).when("/MyClgFnd/:table",{
        templateUrl:"list.jsp"
    }).when("/Detail/:table/:id",{
        templateUrl:"Detail.jsp"
    });
});
app.controller("MyList",function ($scope,$http,$routeParams) {
    $scope.table=$routeParams.table;
    $scope.List=function (){
    $http({
        url:"List?value="+$scope.table,
        method:"GET"
    }).then(function (response){
        $scope.list=response.data.DATA;
    },function (response){
        console.log(response);
    });
};
});
app.controller("Detail",function ($scope,$http,$routeParams) {
    $scope.PDetail=function (){
    $http({
        url:"PDetail?table="+$routeParams.table+"&id="+$routeParams.id,
        method:"GET"
    }).then(function (response){
        $scope.Detail=response.data.DATA;
        console.log($scope.Detail);
    },function (response){
        console.log(response);
    });
};
});