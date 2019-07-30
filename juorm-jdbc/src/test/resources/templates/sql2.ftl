select * from user<@where>
    <@and if= age??>
        age = :age
    </@and>
    <@and>
        <@and if= name??>
            name = :name
        </@and>
        <@and if= age??>
            age = :age
        </@and>
        <@or>
            <@and if= minAge??>
                age > :minAge
            </@and>
            <@and if= maxAge??>
                age < :maxAge
            </@and>
        </@or>
        <@and if= minAge??>
            age between :minAge and :maxAge 
        </@and>
    </@and>
    <@and if= age??>
        age = :age
    </@and>
    <@or>
        <@and if= name??>
            name = :name
        </@and>
        <@or if= age??>
            age = :age
        </@or>
    </@or>
    <@and if=sex??>
        sex = :sex
    </@and>
    <@and if=mobile??>
        name = :mobile
    </@and>
    <@or if= name??>
        name = :name
    </@or>
    <@or if= age??>
        age = :age
    </@or>
    <@or if=sex??>
        sex = :sex
    </@or>
    <@or if=mobile??>
        mobile = :mobile
    </@or>
</@where>