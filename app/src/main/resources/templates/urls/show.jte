@import hexlet.code.core.dto.UrlPage
@import hexlet.code.core.utils.NamedRoutes

@param UrlPage page

@template.layout.page(
page = page,
content = @`
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">URL</th>
            <th scope="col">Результат</th>
            <th scope="col">Код ответа</th>
            <th scope="col">Время проверки</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="col">${page.getName()}</th>
        </tr>
        </tbody>
    </table>
`
)