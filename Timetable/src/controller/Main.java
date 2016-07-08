package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import TimeTableDM.DegreePlanDM;
import TimeTableDM.UniversityDM;
import TimeTablePD.Courses;
import TimeTablePD.DegreePlan;
import TimeTablePD.Degrees;
import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.Schedule;
import TimeTablePD.Schedule2;
import TimeTablePD.Student;
import TimeTablePD.StudentCourses;
import TimeTablePD.University;

public class Main {

	public static int created = 0;
	static TreeMap<String, ArrayList<DegreePlan>> coursesNeeded = new TreeMap<String, ArrayList<DegreePlan>>();
	static ArrayList<String> coursesOffered = new ArrayList<String>();
	public static TreeMap<String, ArrayList<String>> coursesPassed = new TreeMap<String, ArrayList<String>>();

	static ArrayList<String> couresWithoutReq = new ArrayList<String>();
	static TreeMap<String, Faculty> faculties = new TreeMap<String, Faculty>();

	static TreeMap<String, Degrees> allDegrees = new TreeMap<String, Degrees>();
	static TreeMap<String, Integer> newStudents = new TreeMap<String, Integer>();
	static TreeMap<String, ArrayList<Student>> allEligibleStudentForSem = new TreeMap<String, ArrayList<Student>>();
	public static TreeMap<String, ArrayList<Student>> allEligibleStudentForFall2016 = new TreeMap<String, ArrayList<Student>>();
	static TreeMap<String, ArrayList<Integer>> coursesTimeAndStrengthLeft = new TreeMap<String, ArrayList<Integer>>();
	static TreeMap<String, ArrayList<Courses>> facultiesCoursesList = new TreeMap<String, ArrayList<Courses>>();
	public static TreeMap<String, Integer> facultiesTimeAvail = new TreeMap<String, Integer>();
	static TreeMap<String, TreeMap<String, ArrayList<Courses>>> degreeCoursesOptional = new TreeMap<String, TreeMap<String, ArrayList<Courses>>>();
	static TreeMap<String, ArrayList<Courses>> degreeCoursesReqd = new TreeMap<String, ArrayList<Courses>>();
	static TreeMap<String, Integer> newStudentsleft = new TreeMap<String, Integer>();

	static void Test() {

		for (Map.Entry<String, ArrayList<Courses>> a : Schedule2.stuCrs
				.entrySet()) {
			System.out.println("-----" + a.getKey() + "-----");
			for (Courses c : a.getValue()) {
				System.out.print(c.getCourseCode() + "||");
			}
			System.out.println();
		}

	}

	public static ArrayList<StudentCourses> studentCourses;
	public static TreeMap<String, Student> student = new TreeMap<String, Student>();
	public static University university = new University();
	public static TreeMap<String, Schedule> schedule = new TreeMap<String, Schedule>();

	public static void main(String[] args) {
		UniversityDM uniDM = new UniversityDM();
		University uni = new University();
		uniDM.loadUniversity(uni);
		// //System.out.println("loaded successfully");
	}

	public static void generateSchedule(String sem) {
		schedule = new TreeMap<String, Schedule>();

		coursesNeeded = new TreeMap<String, ArrayList<DegreePlan>>();
		coursesOffered = new ArrayList<String>();
		coursesPassed = new TreeMap<String, ArrayList<String>>();

		couresWithoutReq = new ArrayList<String>();
		faculties = new TreeMap<String, Faculty>();

		allDegrees = new TreeMap<String, Degrees>();
		newStudents = new TreeMap<String, Integer>();
		allEligibleStudentForSem = new TreeMap<String, ArrayList<Student>>();
		allEligibleStudentForFall2016 = new TreeMap<String, ArrayList<Student>>();
		coursesTimeAndStrengthLeft = new TreeMap<String, ArrayList<Integer>>();
		facultiesCoursesList = new TreeMap<String, ArrayList<Courses>>();
		facultiesTimeAvail = new TreeMap<String, Integer>();
		degreeCoursesOptional = new TreeMap<String, TreeMap<String, ArrayList<Courses>>>();
		degreeCoursesReqd = new TreeMap<String, ArrayList<Courses>>();
		newStudentsleft = new TreeMap<String, Integer>();

		Schedule2.stuCrs = new TreeMap<String, ArrayList<Courses>>();
		Schedule2.CrsFac = new TreeMap<String, ArrayList<Faculty>>();
		Schedule2.SchcoursesTimeAndStrengthLeft = new TreeMap<String, ArrayList<Integer>>();
		Schedule2.noOfSections = new TreeMap<String, Integer>();
		Schedule2.newStudent = new TreeMap<String, Integer>();
		Schedule2.facultiesTime = new TreeMap<String, Integer>();

		for (Map.Entry<String, GradSchool> tmp : University.gradSchools
				.entrySet()) {
			for (Map.Entry<String, Degrees> tmp2 : tmp.getValue().degrees
					.entrySet()) {
				Degrees degreeTmp = tmp2.getValue();
				newStudents.put(degreeTmp.getDegreeCode(), new Integer(
						degreeTmp.getForecast()));
				for (Map.Entry<String, Student> tmpSt : student.entrySet()) {
					if ((Integer.parseInt(tmpSt.getValue().getSemCode()
							.substring(0, 4)) == 2016)
							&& (tmpSt.getValue().getSemCode().substring(4)
									.equalsIgnoreCase("FA"))
							&& (tmpSt.getValue().getDegreeCode()
									.equals(degreeTmp.getDegreeCode()))) {
						if (!allEligibleStudentForFall2016
								.containsKey(degreeTmp.getDegreeCode()))
						// checking if degree is avail in treeMap
						// allEligibleStudentForSem
						{
							ArrayList<Student> tmp3 = new ArrayList<Student>();
							allEligibleStudentForFall2016.put(
									degreeTmp.getDegreeCode(), tmp3);
						}
						allEligibleStudentForFall2016.get(
								degreeTmp.getDegreeCode())
								.add(tmpSt.getValue());
						// //System.out.println("flag 1");

					}
					// checking student sem >2016
					if ((Integer.parseInt(tmpSt.getValue().getSemCode()
							.substring(0, 4)) > 2016)
							&& (tmpSt.getValue().getDegreeCode()
									.equals(degreeTmp.getDegreeCode()))) {
						if (!allEligibleStudentForSem.containsKey(degreeTmp
								.getDegreeCode()))
						// checking if degree is avail in treeMap
						// allEligibleStudentForSem
						{
							ArrayList<Student> tmp3 = new ArrayList<Student>();
							allEligibleStudentForSem.put(
									degreeTmp.getDegreeCode(), tmp3);

						}
						allEligibleStudentForSem.get(degreeTmp.getDegreeCode())
								.add(tmpSt.getValue());
						// //System.out.println("flag 1");

					}
				}
			}
		}

		// now all eligible student are present in the allEigibleStudentForSem
		// and allEigibleStudentForFall2016 TreeMap
		// students with fall2016 are priority student and forecast
		getAllDegrees();
		getCourseNeededByStudents("2016FA");
		getCoursesWithPreq();
		getCoursesStrengthAndHoursLeft();
		getFacultiesCoursesListAndTimeAvail();
		getDegreeOptionalCourses();
		getDegreeReqdCourses();
		saveFacultyTime();
		allocateSchedule();
		Test();
	}

	static void saveFacultyTime() {
		for (Map.Entry<String, Integer> f : facultiesTimeAvail.entrySet()) {
			Schedule2.facultiesTime.put(f.getKey(), f.getValue());
		}
	}

	static void getAllDegrees() {
		for (Map.Entry<String, GradSchool> a : University.gradSchools
				.entrySet()) {
			for (Map.Entry<String, Faculty> f : a.getValue().faculties
					.entrySet()) {

				if (f.getValue().getMaxLoadFall() <= 0)
					continue;
				if (!faculties.containsKey(f.getKey())) {

					faculties.put(f.getKey(), f.getValue());
				}
			}
			for (Map.Entry<String, Degrees> d : a.getValue().degrees.entrySet()) {

				allDegrees.put(d.getKey(), d.getValue());
			}
		}
	}

	static boolean allocateAnotherSection(String degreeName, Courses c) {
		// for (Faculty faculty : faculties.get(degreeName)) {
		for (Map.Entry<String, Faculty> q : faculties.entrySet()) {
			Faculty faculty = q.getValue();
			int timeAvail = facultiesTimeAvail.get(faculty.getLastName());
			if (timeAvail > 0
					&& facultiesCoursesList.containsKey(faculty.getLastName())
					&& facultiesCoursesList.get(faculty.getLastName())
							.contains(c)) {
				// allocate this faculty to the course;
				Schedule2.CrsFac.get(c.getCourseCode()).add(faculty);
				int hours = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(0);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(0, hours - 3);
				int cap = coursesTimeAndStrengthLeft.get(c.getCourseCode())
						.get(1);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(1, cap - 1);
				facultiesTimeAvail.remove(faculty.getLastName());
				facultiesTimeAvail.put(faculty.getLastName(), timeAvail - 3);
				return true;
			}

		}
		return false;

	}

	static boolean findFactultyForTheCourse(String degreeName, Courses c) {
		// for (Faculty faculty : faculties.get(degreeName)) {
		for (Map.Entry<String, Faculty> q : faculties.entrySet()) {
			Faculty faculty = q.getValue();
			int timeAvail = facultiesTimeAvail.get(faculty.getLastName());

			if (timeAvail > 0
					&& facultiesCoursesList.containsKey(faculty.getLastName())
					&& facultiesCoursesList.get(faculty.getLastName())
							.contains(c)) {
				// allocate this faculty to the course;
				if (Schedule2.CrsFac.containsKey(c.getCourseCode())) {
					Schedule2.CrsFac.get(c.getCourseCode()).add(faculty);
				} else {
					ArrayList<Faculty> a1 = new ArrayList<Faculty>();
					a1.add(faculty);
					Schedule2.CrsFac.put(c.getCourseCode(), a1);

					Schedule2.noOfSections.put(c.getCourseCode(), 1);

				}

				int cap = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(1);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(1, cap - 1);
				int hours = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(0);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(0, hours - 3);

				facultiesTimeAvail.remove(faculty.getLastName());
				facultiesTimeAvail.put(faculty.getLastName(), timeAvail - 3);
				return true;
			}

		}
		return false;

	}

	static int findFactultyForTheCourseNewStudent(String degreeName, Courses c) {
		for (Map.Entry<String, Faculty> q : faculties.entrySet()) {
			Faculty faculty = q.getValue();
			int timeAvail = facultiesTimeAvail.get(faculty.getLastName());

			if (timeAvail > 0
					&& facultiesCoursesList.containsKey(faculty.getLastName())
					&& facultiesCoursesList.get(faculty.getLastName())
							.contains(c)) {
				// allocate this faculty to the course;
				if (Schedule2.CrsFac.containsKey(c.getCourseCode())) {
					Schedule2.CrsFac.get(c.getCourseCode()).add(faculty);
				} else {
					ArrayList<Faculty> a1 = new ArrayList<Faculty>();
					a1.add(faculty);
					Schedule2.CrsFac.put(c.getCourseCode(), a1);

					Schedule2.noOfSections.put(c.getCourseCode(), 1);

				}

				int cap = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(1);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(1, 0);
				if (Schedule2.newStudent.containsKey(c.getCourseCode())) {
					int a = Schedule2.newStudent.get(c.getCourseCode());
					Schedule2.newStudent.remove(c.getCourseCode());
					Schedule2.newStudent.put(c.getCourseCode(), a + cap);
				} else
					Schedule2.newStudent.put(c.getCourseCode(), cap);
				int hours = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(0);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(0, hours - 3);

				facultiesTimeAvail.remove(faculty.getLastName());
				facultiesTimeAvail.put(faculty.getLastName(), timeAvail - 3);
				return cap;
			}

		}
		return -1;

	}

	static int allotSectionsToNewStudent(String degreeName, int num) {

		int flag = 1;
		while (num > 0) {
			int save = num;
			for (Courses c : degreeCoursesReqd.get(degreeName)) {
				if(!coursesOffered.contains(c.getCourseCode()))
					continue;
				if (!Schedule2.CrsFac.containsKey(c.getCourseName())) {
					int flag2 = 1;
					while (flag2 == 1) {
						int capacity = Schedule2.SchcoursesTimeAndStrengthLeft
								.get(c.getCourseCode()).get(1);
						if (capacity < 0)
							break;

						if (Schedule2.SchcoursesTimeAndStrengthLeft.get(
								c.getCourseCode()).get(0) <= 0)
							break;
						int f = findFactultyForTheCourseNewStudent(degreeName,
								c);
						// System.out.println("value returned = " + f);
						flag = 0;
						if (f == -1) {
							flag2 = 0;
						} else
							num -= f;
					}
				}

			}
			if (num == save)
				break;
		}
		return num;

	}

	static boolean allocateCourseForThisSem(String degreeName, Courses c,
			Student s) {
		int capacity = Schedule2.SchcoursesTimeAndStrengthLeft.get(
				c.getCourseCode()).get(1);
		if (capacity >= 1) {
			if (!Schedule2.CrsFac.containsKey(c.getCourseCode())) {
				// no faculty alloted
				if (Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(0) <= 0)
					return false;

				boolean f = findFactultyForTheCourse(degreeName, c);
				if (f == false)
					return false;

			} else {
				int cap = Schedule2.SchcoursesTimeAndStrengthLeft.get(
						c.getCourseCode()).get(1);
				Schedule2.SchcoursesTimeAndStrengthLeft.get(c.getCourseCode())
						.set(1, cap - 1);
			}
			if (!Schedule2.stuCrs.containsKey(s.getStudentID())) {
				ArrayList<Courses> c2 = new ArrayList<Courses>();
				c2.add(c);
				Schedule2.stuCrs.put(s.getStudentID(), c2);
			} else {
				Schedule2.stuCrs.get(s.getStudentID()).add(c);

			}
		} else // capacity of course gets filled...Allot new section to it
		{
			boolean b = allocateAnotherSection(degreeName, c);
			return b;
		}
		return true;
	}

	static void makeDuplicateCopyOfCourseTimeAndStrength() {
		for (Map.Entry<String, ArrayList<Integer>> m : coursesTimeAndStrengthLeft
				.entrySet()) {
			ArrayList<Integer> i = new ArrayList<Integer>();
			i.add(m.getValue().get(0));
			i.add(m.getValue().get(1));

			Schedule2.SchcoursesTimeAndStrengthLeft.put(m.getKey(), i);
		}

	}

	static void allocateSchedule() {
		// TreeMap<Courses, ArrayList<Integer>> coursesTimeAndStrengthLeft
		makeDuplicateCopyOfCourseTimeAndStrength();

		for (Map.Entry<String, ArrayList<Student>> mA : allEligibleStudentForFall2016
				.entrySet()) {
			// for all degree
			for (Student s : mA.getValue()) {
				for (DegreePlan dp1 : coursesNeeded.get(s.getStudentID())) {
					if (coursesOffered
							.contains(dp1.getCourse().getCourseCode())) {
						if (degreeCoursesReqd.get(mA.getKey()).contains(
								dp1.getCourse())) {
							allocateCourseForThisSem(mA.getKey(),
									dp1.getCourse(), s);

						}
					}
				}

			}
		}// for loop for degree ends here

		for (Map.Entry<String, ArrayList<Student>> mA : allEligibleStudentForFall2016
				.entrySet()) {
			for (Student s : mA.getValue()) {
				for (Map.Entry<String, ArrayList<Courses>> optCourses : (degreeCoursesOptional
						.get(s.getDegreeCode())).entrySet()) {

					int noOfCr = Integer.parseInt(optCourses.getKey()
							.substring(2));
					for (Courses c : optCourses.getValue()) {
						if (coursesOffered.contains(c.getCourseCode())) {
							boolean b = allocateCourseForThisSem(mA.getKey(),
									c, s);
							if (b == true) {
								noOfCr--;
								if (noOfCr == 0)
									break;
							}
						}
					}
				}

			}
		}// for loop for degree ends here

		// for new comers
		for (Map.Entry<String, Integer> s : newStudents.entrySet()) {
			String degreeName = s.getKey();
			int num = s.getValue();
			int n = allotSectionsToNewStudent(degreeName, num);
			newStudentsleft.put(degreeName, n);

		}
		for (Map.Entry<String, ArrayList<Student>> mA : allEligibleStudentForSem
				.entrySet()) {
			if (allEligibleStudentForFall2016.containsKey(mA.getKey()))
				continue;
			// for all degree
			for (Student s : mA.getValue()) {
				for (Courses dp1 : degreeCoursesReqd.get(s.getDegreeCode())) {
					if (coursesOffered.contains(dp1.getCourseCode())) {
						allocateCourseForThisSem(s.getDegreeCode(), dp1, s);
					}
				}
			}

		}
		for (Map.Entry<String, ArrayList<Student>> mA : allEligibleStudentForSem
				.entrySet()) {
			if (allEligibleStudentForFall2016.containsKey(mA.getKey()))
				continue;
			for (Student s : mA.getValue()) {
				for (Map.Entry<String, ArrayList<Courses>> optCourses : (degreeCoursesOptional
						.get(s.getDegreeCode())).entrySet()) {
					int noOfCr = Integer.parseInt(optCourses.getKey()
							.substring(2));
					for (Courses c : optCourses.getValue()) {
						if (coursesOffered.contains(c.getCourseCode())) {
							boolean b = allocateCourseForThisSem(mA.getKey(),
									c, s);
							if (b == true) {
								noOfCr--;
								if (noOfCr == 0)
									break;
							}
						}
					}
				}

			}
		}// for loop for degree ends here
	}

	static void getDegreeReqdCourses() {
		for (Map.Entry<String, GradSchool> tmp1 : University.gradSchools
				.entrySet()) {
			for (Map.Entry<String, Degrees> tmp2 : tmp1.getValue().degrees
					.entrySet()) {
				Degrees degree = tmp2.getValue();
				ArrayList<Courses> reqC = new ArrayList<Courses>();
				for (DegreePlan dp : degree.degreePlan)
					if (dp.getType().equals("Required")) {
						reqC.add(dp.getCourse());
					}
				degreeCoursesReqd.put(degree.getDegreeCode(), reqC);
			}
		}

	}

	static void getDegreeOptionalCourses() {
		for (Map.Entry<String, GradSchool> tmp1 : University.gradSchools
				.entrySet()) {
			for (Map.Entry<String, Degrees> tmp2 : tmp1.getValue().degrees
					.entrySet()) {

				Degrees degree = tmp2.getValue();
				TreeMap<String, ArrayList<Courses>> t1 = new TreeMap<String, ArrayList<Courses>>();
				int total = degree.degreePlan.size();
				int count = 0;
				while (count < total) {
					for (DegreePlan dp : degree.degreePlan) {
						if (dp.getType().equals("Required") == false) {
							ArrayList<Courses> x = new ArrayList<Courses>();
							if (dp.fg == 0) {
								int id = dp.getId();
								dp.fg = 1;
								x.add(dp.getCourse());
								count++;
								for (DegreePlan dp2 : degree.degreePlan) {
									if (dp2.fg == 0
											&& dp2.getId() == id
											&& dp2.getType().equals("Required") == false) {
										x.add(dp2.getCourse());
										dp2.fg = 1;
										count++;
									}
								}
							}
							if (!x.isEmpty()) {

								String s = dp.getId() + "A" + dp.getHours() / 3;
								t1.put(s, x);
							}
						} else
							count++;

					}
				}

				degreeCoursesOptional.put(degree.getDegreeCode(), t1);
			}
		}
	}

	static void getFacultiesCoursesListAndTimeAvail() {
		for (Map.Entry<String, GradSchool> tmp : University.gradSchools
				.entrySet()) {
			for (Map.Entry<String, Faculty> tmp2 : tmp.getValue().faculties
					.entrySet()) {

				for (Map.Entry<String, Courses> tmp3 : University.courses
						.entrySet()) {
					if (tmp3.getValue().doesfacultyTeach(
							tmp2.getValue().getLastName())) {

						if (!facultiesCoursesList.containsKey(tmp2.getValue()
								.getLastName())) {
							ArrayList<Courses> t = new ArrayList<Courses>();
							t.add(tmp3.getValue());
							facultiesCoursesList.put(tmp2.getValue()
									.getLastName(), t);
						} else
							facultiesCoursesList.get(
									tmp2.getValue().getLastName()).add(
									tmp3.getValue());
					}

				}
				facultiesTimeAvail.put(tmp2.getValue().getLastName(),
						new Integer(tmp2.getValue().getMaxLoadFall()));
			}
		}
	}

	static void getCoursesStrengthAndHoursLeft() {
		for (Map.Entry<String, Courses> tmp : University.courses.entrySet()) {
			ArrayList<Integer> i = new ArrayList<Integer>();
			i.add(tmp.getValue().getCourseHours());

			i.add(tmp.getValue().getCourseCap());
			coursesTimeAndStrengthLeft.put(tmp.getValue().getCourseCode(), i);
		}
	}

	static void getCoursesWithPreq() {
		for (Map.Entry<String, Courses> tmp : University.courses.entrySet()) {
			if (tmp.getValue().getCoursePrereqs().size() == 0)
				coursesOffered.add(tmp.getValue().getCourseCode());
		}
	}

	static void getCourseNeededByStudents(String sem) {

		if (schedule.containsKey(sem) == false) {
			// getting all courses being offered in this sem

			for (Map.Entry<String, Courses> c : University.courses.entrySet()) {
				Courses cs = c.getValue();
				if (sem.substring(4).equals("FA")) {
					if (cs.getOfferedFall() == 'Y'
							|| cs.getOfferedFall() == 'y')
						coursesOffered.add(c.getKey());
				} else if (sem.substring(4).equals("SU")) {
					if (cs.getOfferedSummer() == 'Y'
							|| cs.getOfferedSummer() == 'y')
						coursesOffered.add(c.getKey());
				} else if (sem.substring(4).equals("SP")) {
					if (cs.getOfferedSpring() == 'Y'
							|| cs.getOfferedSpring() == 'y')
						coursesOffered.add(c.getKey());
				}
			}
			for (StudentCourses sc : Main.studentCourses) {
				// if(Integer.parseInt(sc.getSemester().substring(0,4))<=2016)
				// {

				if (!(sc.getGrade().equals("W") || sc.getGrade().equals("D") || sc
						.getGrade().equals("F"))) {

					if (coursesPassed.containsKey(sc.getStudentID())) {
						coursesPassed.get(sc.getStudentID()).add(
								sc.getCourseNo());
					} else {
						ArrayList<String> a = new ArrayList<String>();
						a.add(sc.getCourseNo());
						coursesPassed.put(sc.getStudentID(), a);
					}
				}
				// }
			}

			for (Map.Entry<String, Student> s : student.entrySet()) {
				if (Integer.parseInt(s.getValue().getSemCode().substring(0, 4)) <= 2016) {
					String degreeCode = s.getValue().getDegreeCode();
					Degrees d = null;

					for (Map.Entry<String, GradSchool> m : University.gradSchools
							.entrySet()) {

						GradSchool gs = m.getValue();
						for (Map.Entry<String, Degrees> dg : gs.degrees
								.entrySet()) {
							if (dg.getKey().equals(degreeCode)) {
								d = dg.getValue();
								break;
							}

						}
						if (d != null)
							break;
					}
					if (d == null) {

						continue;
					}
					for (DegreePlan dgP : d.degreePlan) {

						int flag = 0;
						if (coursesPassed.containsKey(s.getKey())) {

							for (String s3 : coursesPassed.get(s.getKey())) {
								if (s3.equals(dgP.getCourse().getCourseCode())) {
									flag = 1;
									break;
								}
							}

							if (flag == 0) // courses didnt done
							{
								int flag2 = 0;
								if (coursesNeeded.containsKey(s.getKey())) {
									{
										if (dgP.getCourse().getOfferedFall() == 'Y'
												|| dgP.getCourse()
														.getOfferedFall() == 'y')
											coursesNeeded.get(s.getKey()).add(
													dgP);
									}
								} else {
									if (dgP.getCourse().getOfferedFall() == 'Y'
											|| dgP.getCourse().getOfferedFall() == 'y') {

										ArrayList<DegreePlan> y = new ArrayList<DegreePlan>();
										y.add(dgP);
										coursesNeeded.put(s.getKey(), y);
									}
								}
							}

						}
					}
				}
			}
			for (Map.Entry<String, ArrayList<DegreePlan>> m : coursesNeeded
					.entrySet()) {
				// //System.out.println("student name : " + m.getKey());
				for (DegreePlan s : m.getValue()) {
					// System.out.print(s.getCourse().getCourseCode() + " ");
				}
			}

			for (Map.Entry<String, ArrayList<DegreePlan>> m : coursesNeeded
					.entrySet()) {
				ArrayList<DegreePlan> saved = new ArrayList<DegreePlan>();
				for (DegreePlan s : m.getValue()) {
					int flag3 = 0;
					Courses c = s.getCourse();
					if (c.CoursePrereqs.size() == 0)
						flag3 = 1;
					for (String s3 : c.CoursePrereqs) {

						for (String cp : coursesPassed.get(m.getKey())) {
							if (s3.equals(cp))
								flag3 = 1;
						}
					}
					if (flag3 == 0) {
						saved.add(s);
					}
				}

				for (DegreePlan d : saved) {
					m.getValue().remove(d);
				}

			}
			for (Map.Entry<String, ArrayList<DegreePlan>> m : coursesNeeded
					.entrySet()) {
				for (DegreePlan dq : m.getValue()) {
				}
			}

		}
	}

}
