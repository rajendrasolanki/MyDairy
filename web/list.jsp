<table ng-controller="MyList" ng-init="List()">
    <tr ng-repeat="x in list">
                <td> <img ng-src="image/{{x.img}}"/></td>
                <td ><a href="#Detail/{{table}}/{{x.id}}">{{x.name}}</a></td>
            </tr>
</table>