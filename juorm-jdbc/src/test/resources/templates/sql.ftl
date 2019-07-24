select * from user
<@where>
    <@and if= age??>
        age = ?
    </@and>
    <@and>
        <@and if= name??>
            name = ?
        </@and>
        <@and if= age??>
            age = ?
        </@and>
        <@or>
            <@and if= name??>
                name = ?
            </@and>
            <@or if= age??>
                age = ?
            </@or>
        </@or>
    </@and>
    <@and if= age??>
        age = ?
    </@and>
    <@or>
        <@and if= name??>
            name = ?
        </@and>
        <@or if= age??>
            age = ?
        </@or>
    </@or>
    <@and if=sex??>
        sex = ?
    </@and>
    <@and if=mobile??>
        name = ?
    </@and>
    <@or if= name??>
        name = ?
    </@or>
    <@or if= age??>
        age = ?
    </@or>
    <@or if=sex??>
        sex = ?
    </@or>
    <@or if=mobile??>
        mobile = ?
    </@or>
</@where>

<#--
select * from role
<@where>
    <@and if= name??>
        name != ?
    </@and>
    <@and if= age??>
        age>?
    </@and>
    <@and if= age??>
        age<?
    </@and>
    <@and if= age??>
        age<>?
    </@and>
    <@and if= age??>
        age!=?
    </@and>
    <@and if= mobile??>
        mobile in ?
    </@and>
</@where>
-->