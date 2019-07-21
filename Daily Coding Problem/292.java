// class Group:
//     def __init__(self):
//         self.members = set()
//         self.enemies = set()

//     def __repr__(self):
//         return str(self.members)

//     def add_student(self, student, enemies):
//         self.members.add(student)
//         self.enemies |= set(enemies)


// def get_groups(enemy_map):
//     students = enemy_map.keys()
//     first, second = Group(), Group()
//     for student in students:
//         if not first.members:
//             first.add_student(student, enemy_map[student])
//         elif student not in first.enemies:
//             first.add_student(student, enemy_map[student])
//         elif not second.members:
//             second.add_student(student, enemy_map[student])
//         elif student not in second.enemies:
//             second.add_student(student, enemy_map[student])

//     if len(first.members) + len(second.members) == len(students):
//         return first.members, second.members

//     return False