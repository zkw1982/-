require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

       state: NewState_5
        intent!: /К чему готовы?
        buttons:
            "4 - норм" -> /Bye
            "Буду биться на 5 за себя" -> /Bye
            "Тонуть и плыть только вместе" -> /Bye
        go!: /NewState_5
        intent: /К чему готовы? || onlyThisState = true, toState = "./"

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

    
