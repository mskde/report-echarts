

/*@Controller
@RequestMapping("/json")
public class JsonController {
	@Autowired
	@Qualifier("ssmservice")
	private ssmService ss;

	public ssmService getSsmService() {
		return ss;
	}

	// 获取所有商品信息
	@RequestMapping("/getThings.do")
	@ResponseBody
	public List<Thing> getThings(HttpServletRequest request) {
		List<Thing> list = ss.selectAllThing("ssmwork.selectAllThings");
		return list;
	}

	// 删除一条商品信息
	@RequestMapping("/deleteOneThing.do")
	@ResponseBody
	public Map<Object, Object> deleteOneThing(String id, HttpServletRequest request) {
		System.out.println(id);
		Integer thisId = Integer.parseInt(id);
		int flag = ss.deleteOneThing("ssmwork.deleteOneThing", thisId);
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (flag > 0)
			map.put("data", "删除成功！");
		else
			map.put("data", "删除失败！");
		return map;
	}

	// 插入一条商品信息
	@RequestMapping("/insertOneThing.do")
	@ResponseBody
	public Map<Object, Object> insertOneThing(Thing thing, HttpServletRequest request) {
		// 无视lastId
		System.out.println(thing.getName());
		// 判断id是否更改
		Map<Object, Object> map = new HashMap<Object, Object>();
		Thing thisThing = ss.selectThingById("ssmwork.selectThingById", thing.getId());
		if (thisThing == null) {
			// 新的商品id可用
			int flag = ss.insertThing("ssmwork.insertThing", thing);
			if (flag > 0)
				map.put("data", "添加成功！");
			else
				map.put("data", "添加失败！");
		} else
			map.put("data", "新商品ID不可用，添加失败！");
		return map;
	}

	// 更新一条商品数据
	@RequestMapping("/updateOneThing.do")
	@ResponseBody
	public Map<Object, Object> updateOneThing(String lastId, Thing thing, HttpServletRequest request) {
		// 判断id是否更改
		boolean isIdChange = false;
		Thing thisThing = null;
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (!lastId.equals(thing.getId() + "")) {
			isIdChange = true;
			thisThing = ss.selectThingById("ssmwork.selectThingById", thing.getId());
		}
		if (isIdChange) {
			// 商品id改变
			if (thisThing == null) {
				// 新的商品id可用
				int flag = ss.insertThing("ssmwork.insertThing", thing);
				if (flag > 0) {
					flag = ss.deleteOneThing("ssmwork.deleteOneThing", Integer.parseInt(lastId));
					if (flag > 0)
						map.put("data", "更新成功！");
					else
						map.put("data", "删除旧记录失败，更新失败！");
				} else
					map.put("data", "更新失败！");
			} else
				map.put("data", "新商品ID不可用，更新失败！");
		} else {
			// 商品id不变
			int flag = ss.updateOneThing("ssmwork.updateOneThing", thing);
			if (flag > 0)
				map.put("data", "更新成功！");
			else
				map.put("data", "更新失败！");
		}
		return map;
	}

	// 商品属性查找
	@RequestMapping("getSearchThings.do")
	@ResponseBody
	public List<Thing> getSelectThing(String quality, String value) {
		System.out.println("quality:" + quality + " ,value:" + value);
		String statement = "ssmwork.selectThingBy";
		List<Thing> list = null;
		switch (quality) {
		case "id":
			list = new ArrayList<Thing>();
			list.add(ss.selectThingById(statement + "Id", Integer.parseInt(value)));
			break;
		case "name":
			list = ss.selectThingByName(statement + "Name", value);
			break;
		case "price":
			list = ss.selectThingByPrice(statement + "Price", Double.parseDouble(value));
			break;
		case "producer":
			list = ss.selectThingByProducer(statement + "Producer", value);
			break;
		case "place":
			list = ss.selectThingByPlace(statement + "Place", value);
			break;
		case "productionDate":
			list = ss.selectThingByProductionDate(statement + "ProductionDate", Date.valueOf(value));
			break;
		case "expiryDate":
			list = ss.selectThingByExpiryDate(statement + "ExpiryDate", Date.valueOf(value));
			break;
		}
		return list;
	}

}
*/



/**
 * 	
 * 	@Controller  --标注一个Controller
	@RequestMapping(produces="返回Type和设置码",value="路径",method=RequestMethod.POST)
	@ResponseBody  --直接返回内容，不做跳转
	@RequestParam(defaultValue="",required=false,value="别名")  --标识参数
	required设置参数是否必填
 *//*
	@Autowired
	@Qualifier(value="exerciseServiceImpl")
	private ExerciseService es;
	
	@RequestMapping("/addExercise")
	public Object addExercise(@RequestParam String stu_name,@RequestParam Double limit_time,@RequestParam String danwei) {
		Exercise e=new Exercise();
		e.setStu_name(stu_name);
		e.setLimit_time(limit_time);
		e.setDanwei(danwei);
		e.setStart_time(new Date(System.currentTimeMillis()));
		boolean flag=es.insertData("ExerciseDaoMapper.insertData",e);
		System.out.println(flag);
		if(flag) {
			return "exercise/success";
		}
		return "exercise/failure";
	}
	
	@RequestMapping("/writeParam")
	@ResponseBody
	public Object writeParam(@RequestParam String stu_name,@RequestParam Double limit_time,@RequestParam String danwei) {
		String result="stu_name:"+stu_name+",limit_time:"+limit_time+",danwei:"+danwei;
		System.out.println(result);
		System.out.println("1");
		return result;
	}
	
	@RequestMapping("/writeParam")
	@ResponseBody
	public Object writeParam2(Exercise ex,HttpServletRequest request) {
		String result="stu_name:"+ex.getStu_name()+",limit_time:"+ex.getLimit_time()+",danwei:"+ex.getDanwei();
		System.out.println(result);
		request.getSession().setAttribute("logined","admin");
		return "exercise/success";
	}
//	http://localhost:8080/ssmdemo/exercise/writeParam?stu_name="test"&limit_time=12.2&danwei="CM"
	
	@RequestMapping("/addExerciseMV")
	public ModelAndView addExerciseMV(@RequestParam String stu_name,@RequestParam Double limit_time,@RequestParam String danwei) {
		Exercise e=new Exercise();
		e.setStu_name(stu_name);
		e.setLimit_time(limit_time);
		e.setDanwei(danwei);
		e.setStart_time(new Date(System.currentTimeMillis()));
		boolean flag=es.insertData("ExerciseDaoMapper.insertData",e);
		if(flag) {
//			return "exercise/success";
			ModelAndView mv=new ModelAndView();
			mv.setViewName("exercise/success");
			mv.addObject("modelparam",stu_name);
			return mv;
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("exercise/failure");
		return mv;
//		http://localhost:8080/ssmdemo/exercise/addExerciseMV?stu_name="test"&limit_time=12.2&danwei="CM"
	}
	
	
	@RequestMapping(value="/getExerciseById/{id}")
	@ResponseBody
	public Object getExerciseById(@PathVariable Integer id) {
		System.out.println(id);
		Exercise ex=new Exercise();
		ex.setId(id);
		Exercise get=es.selectDataById("ExerciseDaoMapper.selectDataById", ex);
		
		return get;
//		http://localhost:8080/ssmdemo/exercise/getExerciseById/15
	}
	
	@RequestMapping(value="/getExerciseByLimitTime.do")
	@ResponseBody
	public Object getExerciseByLimitTime(@RequestParam String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om=new ObjectMapper();
		JsonNode rootNode=om.readValue(json, JsonNode.class);
		double limit_time=rootNode.get("limit_time").asDouble();
		List <Exercise> l1=
				es.getExerciseByLimitTime("ExerciseDaoMapper.getExerciseByLimitTime", limit_time);
		
		return l1;
//		http://localhost:8080/ssmdemo/exercise/getExerciseByLimitTime?json={"limit_time":123.0}
//		http://localhost:8080/ssmdemo/exercise/getExerciseByLimitTime?json=%7B"limit_time":123.0%7D
	}
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello() {
		System.out.println("hello");
		return "success";
//		http://localhost:8080/ssmdemo/exercise/hello
	}*/


/*
	@RequestMapping(value="/getRestJSON/{json}"
			,method=RequestMethod.GET)
	@ResponseBody
	public Object getRestJSON(@PathVariable String json) {
		Exercise ex = new Gson().fromJson(json
				,new TypeToken<Exercise>(){}.getType());		
		String result="stu_name:"+ex.getStu_name() ;
		System.out.println(result);
		return result;
		
		//访问路径 http://localhost:8080/ssmdemo/rest/exercise/getRestJSON/{"stu_name":"rest1"}
	}
	
	
	@RequestMapping(value="/getRestJackson/{json}"
			,method=RequestMethod.GET)
	@ResponseBody
	public Object getRestJackson(@PathVariable String json) throws Exception{
		System.out.println(json);
		ObjectMapper om = new ObjectMapper();
		//字符串转实体
		Exercise ex = om.readValue(json, Exercise.class);
//		ex.setStu_name("jackson_name");
		ex.setDanwei("MM");
		ex.setLimit_time(12.2);
		ex.setStart_time(new Date(System.currentTimeMillis()));
		
		String ex_json = om.writeValueAsString(ex);
		System.out.println("实体转字符串：" + ex_json);
		
		return ex;
		
		//访问路径 http://localhost:8080/ssmdemo/rest/exercise/getRestJackson/11
		//访问路径 http://localhost:8080/ssmdemo/rest/exercise/getRestJackson/{"stuName":"rest1"}
		//访问路径 http://localhost:8080/ssmdemo/rest/exercise/getRestJackson/{"id":"28"}
	}*/













