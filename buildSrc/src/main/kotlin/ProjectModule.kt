package main
public sealed class ProjectModule {
    object Main : ProjectModule()
    object Feature : ProjectModule()
    object Domain : ProjectModule()
    object Data : ProjectModule()
}
