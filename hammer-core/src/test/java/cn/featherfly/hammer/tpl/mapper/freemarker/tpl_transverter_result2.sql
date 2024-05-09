select <@prop>*</@prop> from role
<@where>
<@and if=name?? && name?length gt 0 name="name"> name like ?</@and>
<@or if=name1?? && name1?length gt 0 transverter='CO' name="name1">name like ?</@or>
<@or if=name2?? && name2?length gt 0 transverter='SW' name="name2">name like ?</@or>
<@or if=name3?? && name3?length gt 0 transverter='EW' name="name3">name like ?</@or>
</@where>

select <@prop>*</@prop> from role
<@where>
<@and if=name?? && name?length gt 0 name="name"> name like ?</@and>
<@or if=name1?? && name1?length gt 0 transverter='CO' name="name1">name like ?</@or>
<@or if=name2?? && name2?length gt 0 transverter='SW' name="name2">name like ?</@or>
<@or if=name3?? && name3?length gt 0 transverter='EW' name="name3">name like ?</@or>
</@where>