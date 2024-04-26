@import hexlet.code.core.dto.UrlsPage
@import hexlet.code.core.utils.NamedRoutes

@param UrlsPage page

@template.layout.page(
page = page,
content = @`
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">URL</th>
            <th scope="col">Последний результат</th>
            <th scope="col">Код ответа</th>
        </tr>
        </thead>
        <tbody>
        @for(var p : page.getUrls())
            <tr>
                <td>${p.getId()}</td>
                <td><a href="${NamedRoutes.urlPath(p.getId())}"> ${p.getName()}</a></td>
                <td></td>
                <td></td>
            </tr>
        @endfor
        </tbody>
    </table>
`
)