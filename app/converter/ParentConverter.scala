package converter

abstract class ParentConverter[O, D] {

    def objToDTO(obj: O) : D
    def dtoToObj(dto: D): O

}