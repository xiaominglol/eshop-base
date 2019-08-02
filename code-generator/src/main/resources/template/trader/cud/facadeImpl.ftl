
    @PostMapping("${table.facade}")
    void add(@RequestBody ${table.className}Dto ${table.domainName}Dto) {
        ${table.domainName}Feign.add(${table.domainName}Dto);
    }

    @PutMapping("${table.facade}")
    void update(@RequestBody ${table.className}Dto ${table.domainName}Dto) {
        ${table.domainName}Feign.update(${table.domainName}Dto);
    }

    @DeleteMapping("${table.facade}/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        ${table.domainName}Feign.delete(id);
    }

