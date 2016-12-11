<table border="1px" ng-controller="Detail" ng-init="PDetail()">
    <tr>
        <td><img ng-src="image/{{Detail[0].img}}"/></td>
        <td>{{Detail[0].name}}</td>
    </tr>
    <tr>
        <td colspan="2">{{Detail[0].about}}</td>
    </tr>
</table>