select id, username, password pwd, mobile_no, age from user
    <@include name="selectCondition", namespace="user"/>
    <@tpl name="selectCondition2", namespace="user"/>
    <@sql name="selectCondition3", namespace="user"/>