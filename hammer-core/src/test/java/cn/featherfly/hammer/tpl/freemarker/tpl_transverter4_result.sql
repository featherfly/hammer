select <@prop>*</@prop> from role
<@where>
<@and if=birthday?? && birthday?length gt 0 name="birthday"> DATE_FORMAT(birthday,'%Y-%M-%D') = ?</@and>
<@or if=birthday?? && birthday?length gt 0 name="birthday">DATE_FORMAT(birthday,"%Y-%M-%D") = ?</@or>
<@or if=name?? && name?length gt 0 name="name">name like ?</@or>
<@or if=name1?? && name1?length gt 0 transverter='CO' name="name1">name like :name1</@or>
<@or if=name2?? && name2?length gt 0 transverter='SW' name="name2">name like :name2</@or>
<@or if=name3?? && name3?length gt 0 transverter='EW' name="name3">name like :name3</@or>
</@where>
