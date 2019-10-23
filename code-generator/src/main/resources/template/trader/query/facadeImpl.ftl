
    @PostMapping("${table.facade}")
    void add(@RequestBody ${table.className}Dto ${table.smallClassName}Dto) {
    ${table.smallClassName}Feign.add(${table.smallClassName}Dto);
    }

    @PutMapping("${table.facade}")
    void update(@RequestBody ${table.className}Dto ${table.smallClassName}Dto) {
    ${table.smallClassName}Feign.update(${table.smallClassName}Dto);
    }

    @DeleteMapping("${table.facade}/{id}")
    void delete(@PathVariable(value = "id") Long id) {
    ${table.smallClassName}Feign.delete(id);
    }

