#ifndef METHOD_H
#define METHOD_H

#include <cstdlib>
#include <functional>
#include <iostream>

class Entity;
class EntityCore;

struct MethodBase 
{
	const EntityCore *core;
	const size_t id;
	const std::string name;

	MethodBase(const EntityCore *m_core, const size_t m_id, const std::string &m_name)
		: core(m_core), id(m_id), name(m_name)
	{
	}
};

template<class T> 
struct Method : MethodBase
{
};

template<class R, class... A>
struct Method<R(A...)> : MethodBase
{
	const std::function<R(Entity&,A...)> function;

	Method(const EntityCore *m_core, const size_t m_id, const std::string &m_name, const std::function<R(Entity&,A...)> &m_function)
		: MethodBase(m_core, m_id, m_name), function(m_function)
	{
	}
};

#endif