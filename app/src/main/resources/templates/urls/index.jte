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
        @for(var p : page.getUrlTuples())
            <tr>
                <td>${p.getValue0().getId()}</td>
                <td><a href="${NamedRoutes.urlPath(p.getValue0().getId())}"> ${p.getValue0().getName()}</a></td>
                <td>@if (p.getValue1() != null)${p.getValue1().getCreatedAt().toString()}@endif</td>
                <td>@if (p.getValue1() != null)${p.getValue1().getStatusCode()}@endif</td>
            </tr>
        @endfor
        </tbody>
    </table>
`
)