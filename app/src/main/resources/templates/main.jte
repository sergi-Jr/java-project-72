@import hexlet.code.core.utils.NamedRoutes

@template.layout.page(
content = @`
    <form action="${NamedRoutes.urlsPath()}" method="post">
        <div class="form-row">
            <div class="col">
                <label>Type some url below
                    <input type="url" class="form-control" id="url" aria-describedby="urlHelp"
                           placeholder="example.org">
                </label>

            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">Inspect</button>
            </div>

        </div>

    </form>
`
)